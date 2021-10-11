/*

Seperate the ZEROs to the LEFT && ONEs to the RIGHT side of the Array

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

void printArray(int *arr, int size){

	for(int i = 0; i < size; ++i){
		printf(" %d", arr[i]);
	}
	printf("\n");
}

void swap(int *x, int *y){

	int temp = *x;
	*x = *y;
	*y = temp;
}

void seperateZerosOnes(int *arr, int size){

	int left = 0, right = size - 1;

	while(left < right){

		if(arr[left] == 0) { 
			++left;
		}

		if(arr[right] == 1) { 
			--right;
		}

		if(arr[left] == 1 && arr[right] == 0) { 

			swap(&arr[left], &arr[right]);
			++left;
			--right;
		}
	}
}

int main(){ 

	int *arr, i, size;

	printf("\nEnter size :: ");
	scanf("%d", &size);

	arr = (int*)malloc(sizeof(int) * size);

	printf("\nEnter Array (0,1) :: ");
	for(i = 0; i < size; ++i){
		scanf("%d", &arr[i]);
	}

	seperateZerosOnes(arr, size);
	printArray(arr, size);
}
