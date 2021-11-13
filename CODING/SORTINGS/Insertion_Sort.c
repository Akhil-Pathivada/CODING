/* 
Insertion Sort

Time Complexity: O(n ^ 2) 
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>

void PrintArray(int *arr, int size) {

	printf("Array : ");

	for(int i = 0; i < size; ++i) {

		printf(" %d,", arr[i]);
	}
}

void Sort(int *arr, int size) {

	int i, j, key;
	// picking up all the elements
	for(j = 1; j < size; ++j) {

		key = arr[j];
		i = j - 1;
		/* Move elements of arr[0..i-1], that are
          	greater than key, to one position ahead
          	of their current position */
		while(i >= 0 && arr[i] > key) {

			arr[i + 1] = arr[i];
			--i;
		}
		arr[i + 1] = key;
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
	Sort(arr, size);
	PrintArray(arr, size);
}
