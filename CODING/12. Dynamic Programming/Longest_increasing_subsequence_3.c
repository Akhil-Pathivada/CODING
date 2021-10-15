/*
Find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. 
For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.

(Using LCS)

Time Complexity : O(n^2)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

#define max(a,b) (a > b) ? a : b

int compareTo(const void *aptr, const void *bptr) {
	
	return *(int*)aptr - *(int*)bptr;
}

int LCS(int X[], int Y[], int n) {

	int mat[2][n+1];
	bool bi;
		
	for(int i = 0; i <= n; ++i) {

		bi = i & 1;
		
		for(int j = 0; j <= n; ++j) {
			
			if(i == 0 || j == 0) {
				mat[bi][j] = 0;
			}
			
			else if(X[i-1] == Y[j-1]) {
				mat[bi][j] = 1 + mat[1-bi][j-1];
			}
			
			else {
				mat[bi][j] = max(mat[1-bi][j], mat[bi][j-1]);
			}
		}
	}
	return mat[bi][n];	
}


int getLIS(int *arr, int n) {

	int temp[n];
	
	for(int i = 0; i < n; ++i) {
 		temp[i] = arr[i];
	}
		
	qsort(temp, n, sizeof(*temp), compareTo);
	
	return LCS(arr, temp, n);
}

void main() {

	int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
	int n = sizeof(arr) / sizeof(*arr);
	
	printf(" Longest Increasing Subsequence : %d ", getLIS(arr, n));
}
