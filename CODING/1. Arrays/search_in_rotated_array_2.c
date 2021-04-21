/*
Search an element in a sorted and rotated array

Time Complexity : O(logn)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdbool.h>

int findPivot(int arr[],int start,int end) // O(logn)
{
	while(start<=end)
	{
		int mid=(start+end)/2;

		if(arr[mid]>arr[mid+1])
			return mid;

		else if(arr[mid]<arr[start])
			end=mid-1;

		else
			start=mid+1;
	}
}

bool BinarySearch(int arr[],int target,int start,int end) // O(logn)
{
	while(start<=end)
	{
		int mid=(start+end)/2;

		if(arr[mid]==target)
			return true;

		else if(arr[mid]>target)
			end=mid-1;

		else
			start=mid+1;
	}
	return false;
}

bool searchRotatedArray(int arr[],int target,int N)
{
	int pivotIndex=findPivot(arr,0,N-1);

	if(arr[pivotIndex]==target)
		return true;

	return (target>=arr[0]) ?BinarySearch(arr,target,0,pivotIndex-1) :BinarySearch(arr,target,pivotIndex+1,N-1);
}

void main()
{
	int arr[]={3,4,5,01,2};
	searchRotatedArray(arr,3,5) ?printf(" FOUND \n"):printf(" NOT FOUND\n");
}
