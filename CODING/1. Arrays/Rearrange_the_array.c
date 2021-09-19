
/** Given an array arr[] of size n where every element is in range from 0 to n-1. Rearrange the given array so that arr[i] becomes arr[arr[i]].
  * This should be done with O(1) extra space.
  *
  * Examples:
  *
  * Input: arr[]  = {3, 2, 0, 1}
  * Output: arr[] = {1, 0, 3, 2}
  * Explanation:
  * In the given array
  * arr[arr[0]] is 1 so arr[0] in output array is 1
  * arr[arr[1]] is 0 so arr[1] in output array is 0
  * arr[arr[2]] is 3 so arr[2] in output array is 3
  * arr[arr[3]] is 2 so arr[3] in output array is 2
  *
  * Time Complexity : O(N)
  * Space Complexity : O(1)
  *
  *  */
#include<stdio.h>

void printArray(int *arr, int n) {

	for(int i = 0; i < n; ++i) {
		printf(" %d,", arr[i]); 
	}
}

void rearrangeArray(int *arr, int n) {

	for(int i = 0; i < n; ++i) {
		
		arr[i] += (arr[arr[i]] % n) * n; 
	}
		
	for(int i = 0; i < n; ++i) {
		
		arr[i] /= n; 
	}
}

int main() {

	int arr[] = { 4, 0, 2, 1, 3 };
	
	int size = sizeof(arr) / sizeof(*arr);
	
	rearrangeArray(arr, size);
	printArray(arr, size);
}
