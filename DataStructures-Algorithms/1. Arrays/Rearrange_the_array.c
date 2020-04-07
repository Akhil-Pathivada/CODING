/*
Given an array arr[] of size n where every element is in range from 0 to n-1.
Rearrange the given array so that arr[i] becomes arr[arr[i]]. This should be done with O(1) extra space.
*/

#include<stdio.h>

void printArray( int *arr, int n)
{
	for(int i=0; i<n; ++i)
		printf(" %d,", arr[i]);
		
	printf("\n");
}

void rearrangeArray( int *arr, int n)
{
	for(int i=0; i<n; ++i)
		
		arr[i] += (arr[arr[i]] % n) * n;
		
	for(int i=0; i<n; ++i)
		
		arr[i] /= n;
}

void main()
{
	int arr[] = {5,3,4,1,0,2};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	printArray(arr,size);
	
	rearrangeArray(arr,size);
	
	printArray(arr,size);
}
