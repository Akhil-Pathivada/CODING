/*
Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first increasing, then decreasing. 
Write a function that takes an array as argument and returns the length of the longest bitonic subsequence.

(Perfect-Hill problem)

(Dynamic Programming)

Time Complexity : O(n^2)
Space Complexity : O(n)
*/

#include<stdio.h>

int LBS( int *arr, int n)
{
	int i,j;

	int LIS[n], LDS[n];
	
	for(i=0; i<n; ++i)
		LIS[i] = LDS[i] = 1;
		
	// Longest Increasing Subsequence	
	for(i=1; i<n; ++i)
	{
		for(j=0; j<i; ++j)
		{
			if( arr[i] > arr[j] && LIS[i] < LIS[j]+1)
				LIS[i] = LIS[j] + 1;
		}
	}
	
	// Longest Decreasing Subsequence
	for(i=n-2; i>=0; --i)
	{
		for(int j=n-1; j>i; --j)
		{
			if( arr[i] > arr[j] && LDS[i] < LDS[j]+1)
				LDS[i] = LDS[j] + 1;
		}
	}
	
	// Longest Bitonic Subsequence
	
	int max = LIS[0] + LDS[0] - 1;
	
	for(i=1; i<n; ++i)
	{
		if(LIS[i]+LDS[i]-1 > max)
			max = LIS[i]+LDS[i]-1;
	}
	
	return max;
}

void main()
{	
	int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};//{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	printf(" Longest Bitonic Subsequence : %d ", LBS(arr,n));
}
