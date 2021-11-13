/* 
Sorting the elements of an Array using "QUICK SORT" 

Time Complexity : O(N ^ 2)
Space Complexity : O(N)
*/
#include<stdio.h>
#include<stdlib.h>

void PrintArray(int *arr, int size) {

	for(int i = 0; i < size; ++i) {
		printf(" %d,",arr[i]);
	}
}

void Swap(int *p, int *q) {

	int temp = *p;
	*p = *q;
	*q = temp;
}
/* This function takes last element as pivot, places 
the pivot element at its correct position in sorted 
array, and places all smaller (smaller than pivot) 
to left of pivot and all greater elements to right 
of pivot */
int Partition(int *arr, int low, int high) {

	int x = arr[high];
	int i = low - 1;

	for(int j = low; j < high; ++j) {
		// If current element is smaller than the pivot 
		if(arr[j] <= x) {
			Swap(&arr[++i], &arr[j]);
		}
	}
	Swap(&arr[++i], &arr[high]);
	return i;
}

void quickSort(int *arr, int low, int high) {

	if(low < high) {
        	/* pivot is partitioning index, arr[p] is now 
        	at right place */
		int pivot = Partition(arr, low, high);
        	/*Separately sort elements before 
        	partition and after partition */
		quickSort(arr, low, pivot - 1);
		quickSort(arr, pivot + 1, high);
	}
}

int main() {

	int *arr, size;

	printf("Enter size of the Array : ");	
	scanf("%d", &size);	

	arr = (int*)malloc(sizeof(int) * size);
	
	printf("Enter the Array : ");	
	for(int i = 0; i < size; ++i) {

		scanf("%d", &arr[i]);
	}

	PrintArray(arr, size);
	quickSort(arr, 0, size - 1);

	printf("** Sorted Successfully **");
	PrintArray(arr, size);
}
