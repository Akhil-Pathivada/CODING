/** 
  * Given an array of positive and negative integers, seperate them in linear time and constant space. 
  * The output should print all negative numbers, followed by positive numbers.
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

void sortPositiveNegative(int arr[], int n) {

	// take pivot as 1
	int pivot = 0;
	int j = 0;

	for(int i = 0; i < n; ++i) {

		if(arr[i] < pivot) {
		    
			swap(&arr[i], &arr[j++]);
		}
	}
}

int main() {

	int arr[] = { 9, -3, 5, -2, -8, -6, 1, 3 };

	int n = sizeof(arr) / sizeof(*arr);

	sortPositiveNegative(arr, n);
	for (int i = 0; i < n; i++) {
		
		printf(" %d, ", arr[i]);
	}
}
