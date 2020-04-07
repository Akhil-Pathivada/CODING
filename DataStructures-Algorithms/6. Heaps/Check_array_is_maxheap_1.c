/*
Given an array, check if the given array represents a Binary Max-Heap.

Time Complexity : O(n)
Space Complexity : O(log n)
*/
#include<stdio.h>
#include<stdbool.h>

bool isMaxHeap( int *arr, int i, int n)
{
	if(i > (n-2)/2)
		return true;
	
	int left = 2*i+1;
	
	int right = 2*i+2;	
		
	return arr[i] >= arr[left] && arr[i] >= arr[right] &&
	       isMaxHeap(arr, left, n) && 
	       isMaxHeap(arr, right, n);
}

void main()
{
	int arr[] = {90, 15, 10, 7, 12, 2};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	printf(isMaxHeap(arr, 0, n) ? "Yes" : "No");
}
