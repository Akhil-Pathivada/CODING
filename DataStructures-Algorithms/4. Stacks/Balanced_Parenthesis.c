/*
Checking Balanced Parenthesis in the Expression....

Time Complexity : O(n)
*/

#include<stdio.h>
#include<string.h>
#define MAX 100

char stack[MAX], expr[MAX], *s=expr;

int top=-1;

void Push(char c)
{
	if(top == MAX) 
		printf("\n** STACK is full **");
	else
		stack[++top] = c;
}

void Pop()
{
	top--;
}

int Check(char c)
{
	if((c==']' && stack[top]=='[') || (c==')' && stack[top]=='(') || (c=='}' && stack[top]=='{')) 
	{
		Pop();
		return 1;
	}
	return 0;
}
void main()
{
	printf("\nEnter the expression :: ");
	scanf("%s",expr);

	while(*s!='\0')
	{
		if(*s=='['||*s=='{'||*s=='(') 
			Push(*s);

		else if (*s==']'||*s=='}'||*s==')')
		{
			if(!(Check(*s))) 
			{
				printf("\n** UNBALANCED EXPRESSION **\n");
				return;
			}
		}
		s++;
	}

	(top>-1)?printf("\n** UNBALANCED EXPRESSION **\n"):printf("\n** BALANCED EXPRESSION **\n");
}
