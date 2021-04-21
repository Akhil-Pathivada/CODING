/*
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum. 

(Kadane's Algorithm)

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>

#define max(a,b)  (a>b) ? a : b

void maxSubArraySum( int arr[], int n)
{
	int currSum, maxSoFar;
	
	currSum = maxSoFar = arr[0];
	
	for(int i=1; i<n; ++i)
	{
		currSum = max(currSum+arr[i], arr[i]);
		
		maxSoFar = max(maxSoFar, currSum);
	}

	printf(" Max. sum in a contiguous Subarray : %d ",maxSoFar);
}

void main()
{
	int arr[] = {-3, 10, 5, -20, 4, 11, -5, 7};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	maxSubArraySum(arr,n);
}


