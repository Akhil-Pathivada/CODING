/*
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum. 

(Kadane's Algorithm)

Same as previous solution, just we print start and end indexes here.

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>

#define max(a, b)  (a > b) ? a : b

void maxSubArraySum(int arr[], int n) {

	int currSum, maxSoFar, start, end = -1;
	currSum = maxSoFar = arr[0];
	
	for(int i = 1; i < n; ++i) {

		currSum += arr[i];

		if(currSum > maxSoFar) {

			maxSoFar = currSum;
			end = i;
		}

		if(currSum < 0) {
			currSum = 0;
		}
	}
	start = end;
	// finding the start index
	for(int sum = 0; sum != maxSoFar; --start) {

		sum += arr[start];
	}

	printf(" Max. sum in a contiguous Subarray is : %d, found between indexes %d and %d", maxSoFar, start + 1, end);
}

int main() {

	int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
	
	int n = sizeof(arr) / sizeof(*arr);
	
	maxSubArraySum(arr, n);
}


