/*
Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number. 

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>

void findSubArray(int arr[], int N, int target) {

	int start = 0;
	
	int sum = arr[0];
	
	for(int i = 1; i < N; ++i) {

		sum += arr[i];
		
		while(sum > target && start < i-1) {

				sum -= arr[start++];
		}
		
		if(sum == target) {

			printf("Sum found between %d and %d ", start, i);
			return;
		}
	}
	printf(" No SubArray found ");
}

int main() {

	int arr[] = {1, 5, 20, 3, 10, 4};
	
	findSubArray(arr, 6, 33);
}
