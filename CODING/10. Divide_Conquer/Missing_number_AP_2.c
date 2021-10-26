/*
Given an array that represents elements of arithmetic progression in order. 
One element is missing in the progression, find the missing number. 

(Divide & Comquer)

Time Complexity : O(logN)
Space Complexity : O(logN)
*/

#include<stdio.h>
#include<limits.h>

int getNthTerm(int a, int d, int N) {

	return a + (N - 1) * d;
}

int findMissingNumber(int arr[], int diff, int start, int end) {

	if(start > end) {
		return INT_MAX;
	}
	
	int mid = (start + end) / 2;
	
	if(arr[mid + 1] - arr[mid] != diff) {
		return arr[mid] + diff;
	}
		
	if(arr[mid] == getNthTerm(*arr, diff, mid + 1)) {
		return findMissingNumber(arr, diff, mid + 1, end);
	}
		
	if(mid > 0 && (arr[mid] - arr[mid - 1] != diff)) {
		return arr[mid - 1] + diff;
	}	
	return findMissingNumber(arr, diff, start, mid - 1);	
}

int main() {

	int arr[] = {-2, 0, 2, 4, 6, 8, 12, 14};
	int n = sizeof(arr) / sizeof(*arr);
	
	int firstTerm = *arr;
	int lastTerm = arr[n-1];
	int diff = (lastTerm - firstTerm) / n;
	
	printf(" Missing Number : %d ", findMissingNumber(arr, diff, 0, n - 1));
}
