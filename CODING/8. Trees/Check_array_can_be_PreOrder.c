/*
Given an array of numbers, return true if given array can represent preorder traversal of a Binary Search Tree, else return false.

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdbool.h>
#include<limits.h>

void Push( int *stack, int *top, int val)
{
	stack[++*top] = val;
}

int Pop( int *stack, int *top)
{
	return stack[(*top)--];
}

bool isStackEmpty(int top)
{
	return (top == -1);
}

bool checkArray(int *pre, int n)
{
	int stack[n];
	
	int top = -1;
		
	int root = INT_MIN;
	
	for(int i=0; i<n; ++i)
	{
		if(pre[i] < root)
			return false;
		
		while(!isStackEmpty(top) && stack[top] < pre[i])
			root = Pop(stack, &top);
		
		Push(stack, &top, pre[i]);
	}
	
	return true;	
}

void main()
{
	int pre[] = { 4, 2, 1, 3, 6, 5, 7};
	
	int n = sizeof(pre)/sizeof(*pre);
	
	printf(checkArray(pre,n) ? "True" : "False");
}
