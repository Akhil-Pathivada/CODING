/*
Search an element in a sorted and rotated array

Time Complexity : O(logn)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdbool.h>

bool BinarySearch(int arr[],int target,int start,int end) // O(logn)
{
	if(start>end)
		return false;
	int mid=(start+end)/2;
	if(arr[mid]==target)
		return true;
	if(arr[start]<arr[mid])
	{
		if(target>=arr[start] && target<arr[mid])
			return BinarySearch(arr,target,start,mid-1);
		return BinarySearch(arr,target,mid+1,end);
	}
	if(target>arr[mid] && target<=arr[end])
		return BinarySearch(arr,target,mid+1,end);
	return BinarySearch(arr,target,start,mid-1);
}
bool searchRotatedArray(int arr[],int target,int N)
{
	return BinarySearch(arr,target,0,N-1); 
}
void main()
{
	int arr[]={3,4,5,0,1,2};
	searchRotatedArray(arr,2,6) ?printf(" FOUND \n"):printf(" NOT FOUND\n");
}
