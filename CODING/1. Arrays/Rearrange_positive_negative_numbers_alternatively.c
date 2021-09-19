/** 
  * An array contains both positive and negative numbers in random order.
  * Rearrange the array elements so that positive and negative numbers are placed alternatively.
  * Number of positive and negative numbers need not be equal.
  * If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.
  * For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
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

int partition(int arr[], int size) {

	// take pivot as 1
	int pivot = 1;
	int j = 0;

	for(int i = 0; i < size; ++i) {

		if(arr[i] < pivot) {
		    
			swap(&arr[i], &arr[j++]);
		}
	}
	// index of the first positive element
	return j + 1;
}

void reArrange(int *arr, int size) {

	int pos = partition(arr, size);
	
	for(int neg = 0; neg < pos && pos < size; ++pos, neg += 2) {

		swap(&arr[neg], &arr[pos]);
	}

}

int main() {

	int arr[] = { 9, 8, -3, 5, -2, -5, -7, -4, -9, 1};

	int n = sizeof(arr) / sizeof(*arr);

	reArrange(arr, n);
	for (int i = 0; i < n; i++) {
		
		printf(" %d, ", arr[i]);
	}
}

