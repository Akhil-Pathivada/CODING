/*
Given a value N, if we want to make change for N cents,
and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? 
The order of coins doesn’t matter.

(Dynamic Programming)

Time Complexity : O(sum * n)
Space Complexity : O(sum * n)
*/

#include<stdio.h>

int getCount(int *S, int sum, int n) {

	int tab[sum + 1][n];
	int i, j, x, y;
	
	// if we didnt choose any of coins for sum 'zero'
	for(i = 0; i < n; ++i) {
		tab[0][i] = 1;
	}
	
	for(i = 1; i <= sum; ++i) {

		for(j = 0; j < n; ++j) {

			// including element S[j]
			x = (i - S[j] >= 0) ? tab[i - S[j]][j] : 0;
			// excluding element S[j]
			y = (j >= 1) ? tab[i][j - 1] : 0;
			
			tab[i][j] = x + y;
		}
	}
	
	return tab[sum][n - 1];
}

int main() {

	int S[] = {1,2,3};
	int n = sizeof(S) / sizeof(*S);
	int sum = 4;
	
	printf(" Total Ways to Coin Change = %d ", getCount(S, sum, n));
}
