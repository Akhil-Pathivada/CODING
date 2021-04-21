/*
Get the majority element from a sorted array....

Majority Element : element which occurs more than n/2 times

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>

int getMajorityElement(int arr[],int size)
{
	int lastIndex = size%2 ? size/2+1 : size/2;
	
	for(int i=0; i<lastIndex; ++i)
	{
		if(arr[i] == arr[i+size/2])
			return arr[i];
	}
	return -1;
}

void main()
{
	int arr[]={1,1,1,3,3,3,3,3};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	printf(" Majority element : %d ",getMajorityElement(arr,size));
}
