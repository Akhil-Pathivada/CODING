/*
Get the majority element from a sorted array....

Majority Element : element which occurs more than n/2 times

(Divide & Conquer)

Time Complexity : O(logN)
Space Complexity : O(1)
*/

#include<stdio.h>

int getstartIndex( int arr[], int end, int target)
{
	while(end>0)
	{
		if(arr[end-1] != target)
			return end;
		
		else	
			--end;
	}
	return 0;
}

int getMajorityElement(int arr[],int size)
{
	int majority = arr[size/2];
	
	int startIndex = getstartIndex(arr,size/2,majority);
	
	int mIndex = startIndex + size/2;
	
	if(arr[startIndex] == arr[mIndex])
		return majority;
	
	return -1;
}

void main()
{
	int arr[] = {1,2,2,2,2,2,3,3};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	printf(" Majority element : %d ",getMajorityElement(arr,size));
}
