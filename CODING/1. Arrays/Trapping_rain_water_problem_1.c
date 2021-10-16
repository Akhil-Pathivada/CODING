/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Time Complexity : O(n^2)
Space Complexity : O(1)
*/

#include<stdio.h>

int min(int a, int b) {

	return a < b ? a : b;
}

int leftMax(int *arr, int index, int n) {

	int max = arr[index];
	
	for( ; index >= 0; --index) {
		max = arr[index] > max ? arr[index] : max;
	}
		
	return max;
}

int rightMax(int *arr, int index, int n) {

	int max = arr[index];
	
	for( ; index < n; ++index) {
		max = arr[index] > max ? arr[index] : max;
	}
		
	return max;	
}

int getMin(int *arr, int index, int n) {

	return min(leftMax(arr, index, n), rightMax(arr, index, n));
}

int findMaxWater(int *arr, int n) {

	int water = 0;
	
	for(int i = 0; i < n; ++i) {

		water += getMin(arr, i, n) - arr[i]; 
	}
		
	return water;
}

int main() {

	int arr[] = {1, 0, 2, 0, 1, 0, 3, 1, 0, 2};
	int n = sizeof(arr) / sizeof(*arr);
	
	printf(" Max. water that can be holded = %d ", findMaxWater(arr, n));
}
