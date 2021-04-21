/*
Minimum number of bracket reversals needed to make an expression balanced
Time Complexity : O(n)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdbool.h>
#include<string.h>
#include<math.h>
int top=-1;

void Push(stack,val)
char stack[],val;
{
	stack[++top]=val;
}

char Pop(char stack[])
{
	return stack[top--];
}

bool isStackEmpty()
{
	return (top==-1);
}

void balanceExpression(char expr[],int len)
{
	char stack[len];
	int openCount=0,closeCount=0;
	for(int i=0;i<len;i++) //remove the balanced parenthesis
	{
		if(expr[i]=='}' && !isStackEmpty() && stack[top]=='{')
			Pop(stack);
		else
			Push(stack,expr[i]);
	}
	while(top> -1)
		(Pop(stack)=='{') ? openCount++ :closeCount++;

	openCount=(openCount/2)+(openCount%2);
	closeCount=(closeCount/2)+(closeCount%2);
	printf(" min. brackets to be reversed : %d \n", openCount+closeCount);
}

int main()
{
	char expr[]={"{{{{}}"};
	(strlen(expr)&1) ? printf("Expression can't be balanced") : balanceExpression(expr,strlen(expr));
}
