/*
Given an array of integers (both odd and even), sort them in such a way that 
the first part of the array contains odd numbers sorted in descending order, rest portion contains even numbers sorted in ascending order.

(Using negative multiplication)

Time Complexity : O(n*logn)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>

int compareTo( const void *a, const void *b)
{
	return (*(int*)a - *(int*)b);
}

void twoWaySort( int *arr, int n)
{
	// making the Odd elements as '-ve'
	for(int i=0; i<n; ++i)
	{
		if(arr[i]%2)
			arr[i] *= -1;
	}
	
	qsort(arr,n,sizeof(*arr),compareTo);
	
	// retrieving back '-ve' elements to '+ve'
	for(int i=0; i<n; ++i)
	{
		if(arr[i] < 0)
			arr[i] *= -1;
	}
	
	// printing the array
	for(int i=0; i<n; ++i)
		printf(" %d,",arr[i]); 
}

void main()
{
	int arr[] = { 1, 3, 8, 2, 6, 5, 4 ,9, 10, 7};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	twoWaySort(arr,size);
}
