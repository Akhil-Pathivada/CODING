/*
Given an array, check if the given array represents a Binary Max-Heap.

Time Complexity : O(n)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdbool.h>

bool isMaxHeap( int *arr, int i, int n)
{
	if(i > (n-2)/2)
		return true;
	
	int lastRoot = (n-2)/2;
		
	for(int i=0; i<=lastRoot; ++i)	
	{
		int left = 2*i+1;
	
		int right = 2*i+2;
		
		if(arr[left] > arr[i])
			return false;
			
		if(right < n && arr[right] > arr[i])
			return false;
	}
	
	return true;
}

void main()
{
	int arr[] = {90, 15, 10, 7, 12, 2};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	printf(isMaxHeap(arr, 0, n) ? "Yes" : "No");
}
