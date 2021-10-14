/*
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum. 

Time Complexity : O(n^3)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<limits.h>

void maxSubArraySum(int arr[], int n) {

	int maxSum = INT_MIN, start = 0, end = 0;

	
	for(int i = 0; i < n; ++i) {

		for(int j = i; j < n; ++j) {

			int sum = 0;
			
			for(int k = i; k <= j; ++k) {
				sum += arr[k];
			}	
			
			if(sum > maxSum) {

				maxSum = sum;
				start = i;
				end = j;
			}
		}
	}

	printf(" Max. sum in a contiguous Subarray is : %d, found between indexes %d and %d", maxSum, start, end);
}

int main() {

	int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
	
	int n = sizeof(arr) / sizeof(*arr);
	
	maxSubArraySum(arr, n);
}


