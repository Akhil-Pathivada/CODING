/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of Coins = { C1, C2, .. , Cm} valued coins, 
what is the minimum number of coins to make the change?

Time Complexity : O(N).... 'N' is the value
Space Complexity : O(1) 
*/

#include<stdio.h>

void getMinimumCoins( int coins[], int size, int N)
{
	int minCoins=0;
	
	for( int i=size; i>=0; --i)
	{
		while( N >= coins[i])
		{
			N -= coins[i];
			
			printf(" %d,",coins[i]);
			
			++minCoins;
		}
	}
	
	printf("\n Min. Coins : %d ",minCoins);
}

void main()
{
	int N=93;
	
	int coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 }; 
	
	int size = sizeof(coins)/sizeof(*coins);
	
	getMinimumCoins(coins,size-1,N);
}
