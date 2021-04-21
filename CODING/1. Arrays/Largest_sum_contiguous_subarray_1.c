/*
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum. 

Time Complexity : O(n^3)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<limits.h>

void maxSubArraySum( int arr[], int n)
{
	int maxSum = INT_MIN;
	
	for(int i=0; i<n; ++i)
	{
		for(int j=i; j<n; ++j)
		{
			int sum=0;
			
			for(int k=i; k<=j; ++k)
				sum += arr[k];
				
			maxSum = sum > maxSum ? sum : maxSum;
		}
	}

	printf(" Max. sum in a contiguous Subarray : %d ",maxSum);
}

void main()
{
	int arr[] = {-3, 10, 5, -20, 4, 11, -5, 7};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	maxSubArraySum(arr,n);
}


