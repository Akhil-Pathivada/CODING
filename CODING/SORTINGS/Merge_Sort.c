/*
 Sorting the elements of an Array using "MERGE SORT" 
 
 Time Complexity : O(N * logN)
 Space Complexity : O(logN)
*/
#include<stdio.h>
#include<stdlib.h>
#include<limits.h>

void MERGE(int *arr, int p, int q, int r) {

	int n1 = q - p + 1;
	int n2 = r - q;
	int *Left, *Right;
        int i, j, k;

	Left = (int*)malloc(sizeof(int) * n1);
	Right = (int*)malloc(sizeof(int) * n2);

	for(i = 0; i < n1; ++i) {
		
		Left[i] = arr[p + i]; 
	}
	for(j = 0;j < n2; ++j) {

		Right[j] = arr[q + j + 1]; 
	}

	Left[n1] = Right[n2] = INT_MAX;

	i = j = 0;
	for(k = p; k <= r; ++k) {

		if(Left[i] <= Right[j]) {

			arr[k] = Left[i++]; 
		}
		else {

			arr[k] = Right[j++]; 
		}
	}
}

void MergeSort(int *arr, int p, int r) {

	if(p < r) {

		int q = (p + r) / 2;

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
