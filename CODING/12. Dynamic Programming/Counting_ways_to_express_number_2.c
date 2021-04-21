/*
Given N, count the number of ways to express N as sum of 1, 3 and 4.

(Dynamic Programming Approach)
Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>

int countWays(int n)
{
	int DP[n+1];
	
	DP[0] = DP[1] = DP[2] = 1;
	
	DP[3] = 2;
	
	for(int i=4; i<=n; ++i)
		DP[i] = DP[i-1] + DP[i-3] + DP[i-4]; 
		
	return DP[n];
}

void main()
{
	int n = 10;
	
	printf("Total Ways = %d ", countWays(n));
}
