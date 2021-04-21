/*
Given an array, there exists an index 'i' such that arr[0]....arr[i] are in  increasing order and arr[i+1].....arr[n] are in decreasing order.
Get that number.

(Divide & Conquer)

Time Complexity : O(logN)
Space Complexity : O(logN)
*/

#include<stdio.h>

int getNumber( int arr[], int start, int end)
{
	if(start == end)
		return arr[start];
		
	if( end == start+1 && arr[start] >= arr[end])
		return arr[start];
	
	if( end == start+1 && arr[start] < arr[end])
		return arr[end];
	
	int mid = (start+end)/2;
	
	if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
		return arr[mid];
	
	if(arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1])
		return getNumber(arr, start, mid-1);
		
	return getNumber(arr, mid+1, end);
}

void main()
{
	int arr[] = {2,3,4,5,20,18,15,14,13,12,10};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	printf(" Result : %d ",getNumber(arr, 0, n-1));
}
