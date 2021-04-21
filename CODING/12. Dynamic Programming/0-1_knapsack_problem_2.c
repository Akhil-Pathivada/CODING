/*
Given weights and profits of n items, put these items in a knapsack of weight W to get the maximum total profit in the knapsack.

(Dynamic Programming - Bottom Up approach)

Time Complexity : O(n*W)
Space Complexity : O(n*W)
*/

#include<stdio.h>

#define max(a,b)  (a>b) ? a : b  

int fillKnapsack( int weight[], int profit[], int W, int n)
{
	
	int mat[n+1][W+1];
	
	for( int i=0; i<=n; ++i)
	{
		for( int j=0; j<=W; ++j)
		{
			
			if( !i || !j)
				mat[i][j] = 0;
				
			else if(weight[i-1] <= j)
				mat[i][j] = max(profit[i-1] + mat[i-1][j-weight[i-1]] , mat[i-1][j]);
			
			else
				mat[i][j] = mat[i-1][j];
		}
	}
	
	return mat[n][W];
}

void main()
{
	int weight[] = {10,20,30};
	int profit[] = {60,100,120};
	
	int n = sizeof(weight)/sizeof(*weight);
	
	int W = 50;
	
	printf(" Max. Profit : %d ", fillKnapsack(weight,profit,W,n));
}
