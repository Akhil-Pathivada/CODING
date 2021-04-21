/** 
  * Given an array of n elements containing elements from 0 to n-1, with any of these numbers appearing any number of times,
  * find these repeating numbers in O(n) and using only constant memory space.
  *
  * Time Complexity: O(N)
  * Space Complexity: O(1)
  *  */

#include<stdio.h>

void printDuplicates(int *arr, int n) {

	for(int i = 0; i < n; ++i) {

		int index = arr[i] % n;
		arr[index] += n;
	}
	for(int i = 0; i < n; ++i) {

		if((arr[i] / n) > 1) {
			printf(" %d,", i);
		}
	}
}

int main() {

	int arr[] = { 1, 6, 3, 1, 3, 6, 6};

	int n = sizeof(arr) / sizeof(*arr);

	printDuplicates(arr, n);
}
