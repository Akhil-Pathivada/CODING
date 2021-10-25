/*
Count inversions in an Array....(Divide & Conquer)

The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

Time Complexity : O(N * logN)
Space Complexity : O(logN) + O(N)
*/

#include<stdio.h>
#include<stdlib.h>

int Merge(int arr[], int temp[], int leftIndex, int middle, int rightIndex) {

	int index, startIndex, midIndex, invCount = 0;

	index = startIndex = leftIndex;
	midIndex = middle;

	while(leftIndex < middle && middle <= rightIndex) {

		if(arr[leftIndex] <= arr[middle]) {
			temp[index++] = arr[leftIndex++];
		}
		else {
			temp[index++] = arr[middle++];
			invCount += midIndex - leftIndex;
		}
	}
	
	while(leftIndex < middle) {
		temp[index++] = arr[leftIndex++];
	}
	
	while(middle <= rightIndex) {
		temp[index++] = arr[middle++];
	}
		
	for( ; startIndex <= rightIndex; ++startIndex) {
		arr[startIndex] = temp[startIndex];
	}
	return invCount;
}

int MergeSort(int *arr, int *temp, int start, int end) {

	int invCount = 0;	
	
	if(start < end) {

		int mid = (start + end) / 2;
		
		invCount += MergeSort(arr, temp, start, mid);
		invCount += MergeSort(arr, temp, mid + 1, end);
		
		invCount += Merge(arr, temp, start, mid + 1, end);
	}
	return invCount;
}

int countInversions(int *arr, int size) {

	int *temp = (int*)calloc(size, sizeof(int));
	
	return MergeSort(arr, temp, 0, size - 1);
}

int main() {

	int arr[] = {3, 2, 5, 7, 4, 1, 6};
	int size = sizeof(arr) / sizeof(*arr);
	
	printf(" total inversions : %d ", countInversions(arr, size));
}
