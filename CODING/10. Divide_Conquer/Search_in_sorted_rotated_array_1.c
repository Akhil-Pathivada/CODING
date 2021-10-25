/*
Search an element in a sorted and rotated array

Time Complexity : O(N)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdbool.h>

int findPivot(int arr[], int N) { // O(N)

	for(int i = 1; i < N; ++i) {

		if(arr[i] > arr[i + 1]) {
			return i;
		}
	}
	return -1;
}

bool BinarySearch(int arr[],int target,int start,int last) { // O(logN)

	while(start <= last) {

		int mid = (start + last) / 2;

		if(arr[mid] == target) {
			return true;
		}
		else if(arr[mid] > target) {
			last = mid - 1;
		}
		else {
			start = mid + 1;
		}
	}
	return false;
}

bool searchRotatedArray(int arr[], int target, int N) {

	int pivotIndex = findPivot(arr, N);

	if(arr[pivotIndex] == target) {
		return true;
	}

	if(target >= arr[0]) {
		return BinarySearch(arr, target, 0, pivotIndex - 1);
	}
	return BinarySearch(arr, target, pivotIndex + 1, N - 1);
}

int main() {

	int arr[] = {3, 4, 5, 1, 2};
	int size = sizeof(arr) / sizeof(*arr);
	int target = 4;

	printf(searchRotatedArray(arr, target, size) ? "Found" : "Not Found");
}
