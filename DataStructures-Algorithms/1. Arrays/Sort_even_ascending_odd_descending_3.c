/*
Given an array of integers (both odd and even), sort them in such a way that 
the first part of the array contains odd numbers sorted in descending order, rest portion contains even numbers sorted in ascending order.

Time Complexity : O(n*logn)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>

int compareTo( const void *aptr, const void *bptr)
{
	int a = *(int*)aptr;
	
	int b = *(int*)bptr;
	
	if(a%2==0 && b%2==0)
		return a - b;
		
	if (a%2 && b%2)
		return b - a;
	
	if(a%2 == 0)
		return 1;
	
	return 0;
}

void twoWaySort( int *arr, int n)
{	
	qsort(arr,n,sizeof(*arr),compareTo);
	
	for(int i=0; i<n; ++i)
		printf(" %d,",arr[i]); 
}

void main()
{
	int arr[] = { 1, 3, 8, 2, 6, 5, 4 ,9, 10, 7};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	twoWaySort(arr,size);
}
