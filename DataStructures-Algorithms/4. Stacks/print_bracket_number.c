/*
Given an expression exp of length n consisting of some brackets.
The task is to print the bracket numbers when the expression is being parsed.

Time Complexity : O(n)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int *right_bnum;

int Push(int num)
{
	*right_bnum++ = num;
}

int Pop()
{
	return *--right_bnum;
}

void main()
{
	char *exp="((a+b)()*(c+d))";
	
	right_bnum = (int*)malloc(sizeof(int)*strlen(exp));
	
	int left_bnum = 0;
	
	while(*exp)
	{
		if(*exp=='(')
			Push(++left_bnum) && printf(" %d",left_bnum);
			
		else if(*exp==')')
			printf(" %d", Pop());
			
		exp++;
	}
}

