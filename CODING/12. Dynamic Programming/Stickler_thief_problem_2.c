/** 
  * https://www.gohired.in/2017/12/28/stickler-thief/
  *
  * DP Approach
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *  */


#include<stdio.h>
#include<stdlib.h>

#define max(a, b) a > b ? a : b

// calculate the maximum stolen value
int maxLoot(int *arr, int n) {

	if (n == 0) {
		return 0;
	}
	if (n == 1) {
		return arr[0];
	}
	if (n == 2) {
		return max(arr[0], arr[1]);
	}

	// dp[i] represent the maximum value stolen
	// so far after reaching house i.
	int dp[n];

	// Initialize the dp[0] and dp[1]
	dp[0] = arr[0];
	dp[1] = max(arr[0], arr[1]);

	// Fill remaining positions
	for (int i = 2; i < n; i++) {
		dp[i] = max(arr[i] + dp[i-2], dp[i-1]);
	}
	return dp[n-1];
}


int main() {

    int arr[] = {6, 7, 1, 3, 8, 2, 4};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Maximum loot possible = %d ", maxLoot(arr, n));
    return 0;
}

