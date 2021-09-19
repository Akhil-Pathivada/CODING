/** 
  * Given an array of random numbers, Push all the zero’s of a given array to the end of the array.
  * For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same. Expected time complexity is O(n) and extra space is O(1).
  * Example:
  *
  * Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
  * Output : arr[] = {1, 2, 4, 3, 5, 0, 0, 0};
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

void moveZerosToEnd(int arr[], int n) {

	// take pivot as 1
	int pivot = 0;
	int j = 0;

	for(int i = 0; i < n; ++i) {

		if(arr[i] != pivot) {
		    
			swap(&arr[i], &arr[j++]);
		}
	}
}

int main() {

	int arr[] = { 6, 0, 8, 2, 3, 0, 4, 0, 1 };

	int n = sizeof(arr) / sizeof(*arr);

	moveZerosToEnd(arr, n);
	for (int i = 0; i < n; i++) {
		
		printf(" %d, ", arr[i]);
	}
}
