/** 
  * Given an array of n positive integers.
  * Write a program to find the sum of maximum sum subsequence of the given array such that the integers
  * in the subsequence are sorted in increasing order. For example, if input is {1, 101, 2, 3, 100, 4, 5},
  * then output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10
  *
  * Time Complexity: O(2^n)
  * Space Complexity: O(n)
  *  */

#include<stdio.h>
#include<limits.h>
#define max(a, b) a > b ? a : b

int MSIS(int *arr, int i, int n, int prev, int sum) {

	if(i == n) {
		return sum;
	}

	// case 1: exclude the current element and process the
	// remaining elements	
	int exclude = MSIS(arr, i + 1, n, prev, sum);

	// case 2: include the current element if it is greater
	// than the previous element	
	int include = sum;
	if(arr[i] > prev) { 

		include = MSIS(arr, i + 1, n, arr[i], sum + arr[i]);
	}
	return max(include, exclude);
}

int main() {

	int arr[] = {1, 101, 2, 3, 100, 4, 5};
	int n = sizeof(arr) / sizeof(*arr);

	printf("Sum of maximum sum increasing subsequence is = %d", MSIS(arr, 0, n, INT_MIN, 0));
	return 0;
}
