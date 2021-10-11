/*
Write a function to count number of smaller elements on right of each element in an array. 
Given an unsorted array arr[] of distinct integers, construct another array countSmaller[] such that countSmaller[i] contains count of smaller elements on right side of each element arr[i] in array.

Input:   arr[] =  {12, 1, 2, 3, 0, 11, 4}
Output:  countSmaller[]  =  {6, 1, 1, 1, 0, 1, 0} 

Time Complexity : O(N ^ 2)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

void computeCountSmallerArray(int *arr, int *countSmaller, int n) {

	// initialize all the counts in countSmaller array as 0
	for(int i = 0; i < n; ++i) {
		countSmaller[i] = 0;
	}

	for(int i = 0; i < n; ++i) {

		for(int j = i + 1; j < n; ++j) {

			if(arr[j] < arr[i]) {
				countSmaller[i]++;
			}
		}
	}
}

int main() {

	int arr[] = {12, 10, 5, 4, 2, 20, 6, 1, 0, 2};
	int n = sizeof(arr) / sizeof(arr[0]);
	int *countSmaller = (int*)malloc(sizeof(int) * n); // store results in array

	computeCountSmallerArray(arr, countSmaller, n);

	for(int i = 0; i < n; ++i) {
		printf("%d, ", countSmaller[i]);
	}
}