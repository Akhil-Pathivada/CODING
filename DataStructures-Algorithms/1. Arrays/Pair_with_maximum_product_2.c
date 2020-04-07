/*
Given an array with both +ive and -ive integers, return a pair with highest product.

Time Complexity : O(n*logn)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<limits.h>
#include<stdlib.h>

int compareTo(const void *a, const void *b)
{
	return (*(int*)a - *(int*)b);
}

void maxProductPair( int *arr, int n)
{
	qsort(arr,n,sizeof(*arr),compareTo);
	
	if(arr[0]*arr[1] > arr[n-1]*arr[n-2])
		printf(" Max. Product Pair = (%d,%d)", arr[0],arr[1]);
	
	else
		printf(" Max. Product Pair = (%d,%d)", arr[n-1],arr[n-2]);
}

void main()
{
	int arr[] = {1,4,3,6,-9,7,0,5,-2,-5};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	maxProductPair(arr,size);
}
