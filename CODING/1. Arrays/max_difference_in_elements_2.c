/*
Find the maximum difference between two elements such that larger element appears after the smaller element

Time Complexity : O(n)
Space Complexity : O(1)
*/
#include<stdio.h>

int Max(int a, int b){

	return a > b ? a : b;
}

void findMaxDifference(int arr[], int N){

	int maxDiff = arr[1] - arr[0];
	int currMin = arr[0];

	for(int i = 1; i < N; ++i){

		maxDiff = Max(maxDiff, arr[i] - currMin);
		currMin = (arr[i] < currMin) ? arr[i] : currMin;
	}

	printf(" Max.Difference is : %d ", maxDiff);
}

int main(){

	int arr[] = {101, 2, 7, 6, 10, 1, 13, 100};

	findMaxDifference(arr, 8);
}
