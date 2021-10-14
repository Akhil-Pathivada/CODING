/*
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum. 

Time Complexity : O(n^2)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<limits.h>

void maxSubArraySum(int arr[], int n) {

	int  sumArr[n], maxSum = INT_MIN, start = 0, end = 0;
	sumArr[0] = arr[0];
	
	for(int i = 1; i < n; ++i) {
		sumArr[i] = sumArr[i-1] + arr[i]; 
	}
		
	for(int i = 0; i < n; ++i) {

		if(sumArr[i] > maxSum) {

			maxSum = sumArr[i];
			start = end = i;
		}
	}
	
	for(int i = 1; i < n; ++i) {

		int prevSum = sumArr[i-1];
	
		for(int j = i; j < n; ++j) {

			int sum = sumArr[j] - prevSum;

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


