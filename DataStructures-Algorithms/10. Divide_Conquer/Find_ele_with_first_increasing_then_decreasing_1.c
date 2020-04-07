/*
Given an array, there exists an index 'i' such that arr[0]....arr[i] are in  increasing order and arr[i+1].....arr[n] are in decreasing order
Get that number.

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>

int getNumber( int arr[], int n)
{
	for(int i=1; i<n; ++i)
	{
		if(arr[i] > arr[i-1] && arr[i] > arr[i+1])
			return arr[i];
	}
	
	return -1;
}

void main()
{
	int arr[]={2,3,4,5,6,7,8,17,15,12,10};
	int n=sizeof(arr)/sizeof(*arr);
	
	printf(" Result : %d ",getNumber(arr,n-1));
}
