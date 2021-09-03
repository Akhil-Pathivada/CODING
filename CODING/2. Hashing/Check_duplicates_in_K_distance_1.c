/*
Check if a given array contains duplicate elements within k distance from each other.

Time Complexity : O(n*k)
Space Complexity : O(1)
*/

#include<stdio.h>

int checkDuplicates(int arr[], int N, int K) {

	for(int i = 0; i < N - 1; ++i) {

		for(int j = 1; j <= K && i + j < N ; ++j) {

			if(arr[i] == arr[i + j]) {
				return 1;
				
			}
		}
	}
	return 0;
}

int main() {

	int arr[] = {1, 2, 3, 1, 4, 1};
	int K = 2;
	int N = sizeof(arr) / sizeof(*arr);

	printf(checkDuplicates(arr, N, K) ? "Yes" : "No");
}
