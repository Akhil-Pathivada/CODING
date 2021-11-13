/*
 Sorting the elements of an Array using "MERGE SORT" 
 
 Time Complexity : O(N * logN)
 Space Complexity : O(N)
*/
#include<stdio.h>
#include<stdlib.h>
#include<limits.h>

/* Merges two subarrays of arr[].
First subarray is arr[p..q]
Second subarray is arr[q+1..r] */
void MERGE(int *arr, int p, int q, int r) {

	int n1 = q - p + 1;
	int n2 = r - q;
	int *L, *R;
        int i, j, k;

        // create temp arrays 
	L = (int*)malloc(sizeof(int) * n1);
	R = (int*)malloc(sizeof(int) * n2);

	// Copy data to temp arrays L[] and R[]
	for(i = 0; i < n1; ++i) {
		
		L[i] = arr[p + i]; 
	}
	for(j = 0;j < n2; ++j) {

		R[j] = arr[q + j + 1]; 
	}

	L[n1] = R[n2] = INT_MAX;
	i = j = 0;
	// Merge the temp arrays back into arr[p..r]
	for(k = p; k <= r; ++k) {

		if(L[i] <= R[j]) {

			arr[k] = L[i++]; 
		}
		else {

			arr[k] = R[j++]; 
		}
	}
}

void MergeSort(int *arr, int p, int r) {

	if(p < r) {

		int q = (p + r) / 2;
		// Sort first and second halves
		MergeSort(arr, p, q);
		MergeSort(arr, q + 1, r);
		
		MERGE(arr, p, q, r);
	}
}

int main() {

	int arr[] = {8, 7, 6, 5, 9, 4, 3, 2, 1};

	int size = sizeof(arr) / sizeof(*arr);

	MergeSort(arr, 0, size - 1);

	printf("Sorted Array : ");
	for(int i = 0; i < size; ++i) {

		printf(" %d,", arr[i]);	
	}
}
