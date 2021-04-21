/*
Given an array,for each element find the closest greater element which is present on the right side of that element....

(Next Greater Element)

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<string.h>

void Push( int *stack, int *top, int index)
{
	stack[++*top] = index;
}

void Pop(int *top)
{
	--*top;
}

void printNGE( int *arr, int n)
{
	for(int i=0; i<n; i++)
		printf("%d ",arr[i]);	
}

void getNGE( int *arr, int *nge, int n)
{
	int stack[n];
	
	int top = -1;
	
	memset(nge, -1, n*sizeof(*nge));
	
	for(int i=0; i<n; i++)
	{
		while(top>-1 && arr[i] > arr[stack[top]])
		{
			nge[stack[top]] = arr[i];
			
			Pop(&top);
		}

		Push(stack,&top,i);
	}
}

void main()
{
	
	int arr[] = {4, 5, 2, 25};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	int nge[n];
	
	getNGE(arr,nge,n);	
	
	printNGE(nge,n);
}
