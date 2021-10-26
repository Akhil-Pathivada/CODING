/*
Given an array that represents elements of arithmetic progression in order. 
One element is missing in the progression, find the missing number. 

Time Complexity : O(N)
Space Complexity : O(1)
*/

#include<stdio.h>

int findMissingNumber(int arr[], int diff, int n) {

	int sum = arr[0];
	
	for(int i = 1; i < n; ++i) {

		sum += diff;
		
		if(arr[i] != sum) {
			return sum;
		}
	}
	return -1;
}

int main() {

	int arr[] = {-2, 0, 2, 4, 6, 10, 12, 14};
	int n = sizeof(arr) / sizeof(*arr);

	int firstTerm = *arr;
	int lastTerm = arr[n-1];
	int diff = (lastTerm - firstTerm) / n;
	
	printf("Missing Number : %d ", findMissingNumber(arr, diff, n));
}
