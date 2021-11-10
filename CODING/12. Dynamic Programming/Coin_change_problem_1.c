/*
Given a value N, if we want to make change for N cents,
and we have infinite supply of each of S = {S1, S2, .. , Sm} valued coins, how many ways can we make the change? 
The order of coins doesn’t matter.

(Brute-Force Approach)

Time Complexity : O(2 ^ n)
Space Complexity : O(n + sum)
*/

#include<stdio.h>

int getCount(int *S, int sum, int n) {

	if(sum == 0) {
		return 1;
	}
		
	if(sum < 0) {
		return 0;
	}
		
	if(sum && !n) {
		return 0;
	}
	
	return getCount(S, sum - S[n - 1], n) + getCount(S, sum, n - 1);	
}

int main() {

	int S[] = {1, 2, 3};
	int n = sizeof(S) / sizeof(*S);
	int sum = 4;
	
	printf(" Total Ways to Coin Change = %d ", getCount(S, sum, n));
}
