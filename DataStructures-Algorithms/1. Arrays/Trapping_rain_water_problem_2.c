/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>

int min( int a, int b)
{
	return a<b ? a : b;
}

int max( int a, int b)
{
	return a>b ? a : b;
}

int findMaxWater( int *arr, int n)
{
	int left[n], right[n], water=0;
	
	// Computing the Left Array
	left[0] = arr[0];
	
	for(int i=1; i<n; ++i)
		left[i] = max(left[i-1], arr[i]);
		
		
	// Computing the Right Array
	right[n-1] = arr[n-1];
	
	for(int i=n-2; i>=0; --i)
		right[i] = max(right[i+1], arr[i]);
		
	
	// Computing the Result
	for(int i=0; i<n; ++i)
		water += min(left[i],right[i]) - arr[i];
		
	return water;
}

void main()
{
	int arr[] = {1, 0, 2, 0, 1, 0, 3, 1, 0, 2};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	printf(" Max. water that can be holded = %d ",findMaxWater(arr,n));
}
