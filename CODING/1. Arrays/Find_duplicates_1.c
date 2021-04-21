/* 
Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times.
Find these repeating numbers in O(n) and using only constant memory space.
*/

#include<stdio.h>
#include<stdlib.h>

void printDuplicates(int *arr,int size) {

	printf(" Duplicates Elements : ");

	for(int i = 0; i < size; ++i) {

		if(arr[abs(arr[i])] < 0)
			printf(" %d,", abs(arr[i]));

		else
 			arr[abs(arr[i])] = (-1) * arr[abs(arr[i])];
	}
}

int main() {

	int *arr, size;

	printf("\nEnter size of the Array :: ");

	scanf("%d", &size);

	arr = (int*)malloc(sizeof(int)*size);

	printf("\nEnter the Array :: ");

	for(int i = 0; i < size; ++i)
		scanf("%d", &arr[i]);

	printDuplicates(arr, size);
}
