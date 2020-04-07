/*
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum. 

Time Complexity : O(n^2)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<limits.h>

void maxSubArraySum( int arr[], int n)
{
	int  sumArr[n], maxSum = INT_MIN;
	
	sumArr[0] = arr[0];
	
	for(int i=1; i<n; ++i)
		sumArr[i] = sumArr[i-1]+arr[i]; 
		
	for(int i=0; i<n; ++i)
		maxSum = sumArr[i] > maxSum ? sumArr[i] : maxSum; 
	
	for(int i=1; i<n; ++i)
	{
		int prevSum = sumArr[i-1];
		
		for(int j=i; j<n; ++j)
		{
			int tempSum = sumArr[j] - prevSum;
			
			maxSum = tempSum > maxSum ? tempSum : maxSum;
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


