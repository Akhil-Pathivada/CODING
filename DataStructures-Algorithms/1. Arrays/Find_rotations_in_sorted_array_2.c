/*
Consider an array of distinct numbers sorted in increasing order. 
The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.

Time Complexity : O(logn)
Space Complexity : O(1)
*/

#include<stdio.h>

int getRotationCount( int *arr, int start, int end)
{
	int mid = (start+end)/2; 
	
	if(arr[mid] < arr[mid-1])
	 	return mid;
	
	if(arr[mid] > arr[mid+1])
		return mid+1;
	
	if(arr[mid] > arr[end])
		return getRotationCount(arr,mid+1,end);
		
	return getRotationCount(arr,start,mid-1);
}

void main()
{
	int arr[] = {11,12,13,7,8,9,10};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	printf(" Rotations done = %d ",getRotationCount(arr,0,size-1));
}
