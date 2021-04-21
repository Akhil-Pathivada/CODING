/*
Check if an expression has duplicate parenthesis or not.....
Time Complexity : O(n)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdbool.h>
#include<string.h>

int top=-1;

bool isOperator(char ch)
{
	return (ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='%');
}

void Push( char stack[], char ch)
{
	stack[++top] = ch;
}

char Pop(char stack[])
{
	return stack[top--];
}

bool duplicateParenthesis(char expr[],int len)
{
	char stack[len];
	
	char ch, *e = expr;
	
	while(*e)
	{
		if(*e != ')')
			Push(stack,*e);
		else 
		{
			int count=0, opCount=0;
			
			while((ch=Pop(stack)) != '(')
			{
				count++;
				
				opCount = isOperator(ch) ? opCount+1 :opCount;
			}
			
			if(!count || !opCount)
				return true;
		}
		e++;
	}
	return false;
}

int main()
{
	char expr[] = "((a+b)*((a/b)))";
	
	duplicateParenthesis(expr,strlen(expr)) ? printf("True") :printf("Fasle");
}
