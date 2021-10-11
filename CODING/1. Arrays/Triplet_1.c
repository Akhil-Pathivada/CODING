/* 
Find the Triplet whose sum is 'X'

Time Complexity : O(n^3)
Space Complexity : O(1)

*/

#include<stdio.h>
#include<stdlib.h>

void printArray(int *arr, int size) {
	
	printf("\n ARRAY : ");
	for(int i = 0; i < size; ++i) {
		printf(" %d", arr[i]);
	}
}

void findTriplet(int *arr, int size, int X) {

	printf("\n Triplets : ");	
	
	for(int i = 0; i < size; ++i) {

	      for(int j = i+1; j < size; ++j) {

	      	      for(int k = j+1; k < size; ++k) {

	      	      		if(arr[i] + arr[j] + arr[k] == X) {
	      	      			printf(" (%d, %d, %d)", arr[i], arr[j], arr[k]);
	      	      		}
	      	      }
	      }
	}
}

int main() {

	int arr[] = { 1, 4, 45, 6, 10, 8 };
	int size = sizeof(arr) / sizeof(*arr);

	printArray(arr, size);
	
	int X = 22;

	findTriplet(arr, size, X);
}	
