/*
Given a value N, if we want to make change for N cents,
and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? 
The order of coins doesn’t matter.

(Dynamic Programming - Space Optimized)

Time Complexity : O(sum*n)
Space Complexity : O(sum)
*/

#include<stdio.h>
#include<string.h>

int getCount( int *S, int sum, int n)
{
	int table[sum+1];
	
	int i,j,x,y;
		
	memset(table,0,sizeof(table));
		
	table[0] = 1;
	
	for(i=0; i<n; ++i)
	{
		for(j=S[i]; j<=sum; ++j)
		
			table[j] += table[j-S[i]];
	}
	
	return table[sum];
}

void main()
{
	int S[] = {1,2,3};
	
	int n = sizeof(S)/sizeof(*S);
	
	int sum = 4;
	
	printf(" Total Ways to Coin Change = %d ", getCount(S,sum,n));
}
