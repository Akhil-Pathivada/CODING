/*
Count number of SubArrays possible with sum Zero.....

Time Complexity : O(n^3)
Space Complexity :O(1)
*/

#include<stdio.h>

int countSubArrays(int arr[], int N) {

	int count = 0;

	for(int i = 0; i < N; ++i) {

		for(int j = i; j < N; ++j) {

			int sum = 0;
			
			for(int k = i; k <= j; ++k) {
				sum += arr[k];
			}

			if(sum == 0) {
				++count;
			}
		}
	}
	return count;
}

int main() {

	int arr[] = { 11, 10, -5, -3, -2, 10, 7, -1, -6};

	printf(" Total SubArrays : %d ", countSubArrays(arr, 9));
}
