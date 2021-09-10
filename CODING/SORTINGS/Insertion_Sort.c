// Insertion Sort
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

	for(j = 1; j < size; ++j) {

		key = arr[j];

		i = j - 1;

		while(i >= 0 && arr[i] > key) {

			arr[i + 1] = arr[i];

			--i;
		}

		arr[i + 1]=key;
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
