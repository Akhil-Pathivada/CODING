/*
Consider an array of distinct numbers sorted in increasing order. 
The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>

int getRotationCount( int *arr, int n)
{
	for(int i=1; i<n; ++i)
	
		if(arr[i-1] > arr[i])
			return i;
	
	return 0;
}

void main()
{
	int arr[] = {11,12,13,7,8,9,10};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	printf(" Rotations done = %d ",getRotationCount(arr,size));
}
