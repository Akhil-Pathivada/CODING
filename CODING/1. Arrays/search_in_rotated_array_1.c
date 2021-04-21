/*
Search an element in a sorted and rotated array

Time Complexity : O(n)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdbool.h>

int findPivot(int arr[],int N) // O(n)
{
	for(int i=1;i<N;i++)
	{
		if(arr[i]>arr[i+1])
			return i;
	}
}

bool BinarySearch(int arr[],int target,int start,int last) // O(logn)
{
	while(start<=last)
	{
		int mid=(start+last)/2;

		if(arr[mid]==target)
			return true;

		else if(arr[mid]>target)
			last=mid-1;

		else
			start=mid+1;
	}
	return false;
}

bool searchRotatedArray(int arr[],int target,int N)
{
	int pivotIndex=findPivot(arr,N);

	if(arr[pivotIndex]==target)
		return true;

	return (target>=arr[0]) ?BinarySearch(arr,target,0,pivotIndex-1) :BinarySearch(arr,target,pivotIndex+1,N-1);
}

void main()
{
	int arr[]={3,4,5,1,2};
	searchRotatedArray(arr,3,5) ?printf(" FOUND \n"):printf(" NOT FOUND\n");
}
