/*
Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.

Time Complexity : O(n*k)
Space Complexity : O(k)
*/

#include<stdio.h>

void printMax( int *arr, int n, int k)
{
	for(int i=0; i<=n-k; ++i)
	{
		int max = arr[i];
		
		for(int j=i; j<i+k; ++j)
			max = arr[j] > max ? arr[j] : max;
		
		printf("%d ", max);
	}
}

void main()
{
	int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	int k = 3;
	
	printMax(arr,n,k);
}
