/** 
  * Given a binary array, sort it using one traversal and no extra space.
  * Examples :
  *
  *
  * Input : 1 0 0 1 0 1 0 1 1 1 1 1 1 0 0 1 1 0 1 0 0
  * Output : 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1
  * Explanation: The output is a sorted array of 0 and 1
  *
  * Time Complexity : O(N)
  * Space Complexity : O(1)
  *  */

#include<stdio.h>

void swap(int *a, int *b) {

	int temp = *a;
	*a = *b;
	*b = temp;
}

void sortBinaryArray(int arr[], int n) {

	// take pivot as 1
	int pivot = 1;
	int j = 0;

	for(int i = 0; i < n; ++i) {

		if(arr[i] < pivot) {
		    
			swap(&arr[i], &arr[j++]);
		}
	}
}

int main() {

	int arr[] = { 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 };

	int n = sizeof(arr) / sizeof(*arr);

	sortBinaryArray(arr, n);
	for (int i = 0; i < n; i++) {
		
		printf(" %d, ", arr[i]);
	}
}
