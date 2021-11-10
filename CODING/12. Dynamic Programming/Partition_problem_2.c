/*
Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.

(Dynamic Programming)

Time Complexity : O(n * sum)
Space Complexity : O(n * sum)
*/

#include<stdio.h>
#include<stdbool.h>

bool isSubsetSum(int *arr, int sum, int n) {

	bool mat[n+1][sum+1];
	
	for(int i = 0; i <= n; ++i) {
		mat[i][0] = true;
	}
		
	for(int i = 1; i <= sum; ++i) {
		mat[0][i] = false;
	}
	
	for(int i = 1; i <= n; ++i) {

		for( int j = 1; j <= sum; ++j) {

			if(arr[i-1] > j) {
				mat[i][j] = mat[i-1][j];
			}
			else {
				mat[i][j] = mat[i-1][j - arr[i-1]] || mat[i-1][j];
			}
		}
	}
	
	return mat[n][sum];
}

bool checkPartition(int *arr, int N) {

	int sum=0;

	for(int i = 0; i < N; ++i) {
		sum += arr[i];
	}
		
	if(sum & 1) {
		return false;
	}
		
	return isSubsetSum(arr, sum / 2, N);	
}

int main() {

	int arr[] = {3, 1, 5, 9, 12}; 
	int size = sizeof(arr) / sizeof(*arr);
	
	printf(checkPartition(arr, size) ? " YES" : " NO");
}
