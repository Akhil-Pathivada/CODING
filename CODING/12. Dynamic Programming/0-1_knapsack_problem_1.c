/*
Given weights and profits of n items, put these items in a knapsack of weight W to get the maximum total profit in the knapsack.

(Naive approach)

Time Complexity : O(2^n)
Space Complexity : O(n)
*/

#include<stdio.h>

#define max(a,b)  (a>b) ? a : b  

int fillKnapsack( int weight[], int profit[], int W, int n)
{
	if( n==0 || W==0 )
		return 0;
		
	if(weight[n-1] > W)
		return fillKnapsack(weight,profit,W,n-1); 
		
	return  max(profit[n-1] + fillKnapsack(weight,profit, W-weight[n-1], n-1) , fillKnapsack(weight,profit,W,n-1));
}

void main()
{
	int weight[] = {10,20,30};
	int profit[] = {60,100,120};
	
	int n = sizeof(weight)/sizeof(*weight);
	
	int W = 50;
	
	printf(" Max. Profit : %d ", fillKnapsack(weight,profit,W,n));
}
