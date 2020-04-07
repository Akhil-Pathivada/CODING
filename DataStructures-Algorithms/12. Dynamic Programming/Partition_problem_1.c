/*
Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.

(Recursive Naive Approach)

Time Complexity : O(2^n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdbool.h>

bool isSubsetSum( int *arr, int sum, int n)
{
	if(!sum)
		return true;
		
	if(!n && sum)
		return false;	
	
	if(arr[n-1] > sum)
		return isSubsetSum(arr,sum,n-1);
		
	return isSubsetSum(arr, sum-arr[n-1], n-1) || isSubsetSum(arr,sum, n-1); 
}

bool checkPartition( int *arr, int N)
{
	int sum=0;

	for(int i=0; i<N; ++i)
		sum += arr[i];
		
	if(sum & 1)
		return false;
		
	return isSubsetSum(arr, sum/2, N);	
}

void main()
{
	int arr[] = {3, 1, 5, 9, 12}; 
	
	int size = sizeof(arr)/sizeof(*arr);
	
	printf(checkPartition(arr,size) ? " YES" : " NO");
}
