/*
Find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. 
For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.

(Dynamic Programming)

Time Complexity : O(n^2)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>

int LIS(int *arr, int n) {

	int lis[n];
	
	lis[0] = 1; 
		
	for(int i = 1; i < n; ++i) {

	    	lis[i] = 1;
	    
		for(int j = 0; j < i; ++j) {

			if(arr[i] > arr[j] && lis[i] < lis[j] + 1) {
				lis[i] = lis[j] + 1;
			}
		}
	}
	
	int maxLen = lis[0]; 
	
	for(int i = 1; i < n; ++i) {
		maxLen = lis[i] > maxLen ? lis[i] : maxLen;
	}
		
	return maxLen;
}

int main() {

	int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
	int n = sizeof(arr)/sizeof(*arr);
	
	printf(" Longest Increasing Subsequence : %d ", LIS(arr, n));
}
