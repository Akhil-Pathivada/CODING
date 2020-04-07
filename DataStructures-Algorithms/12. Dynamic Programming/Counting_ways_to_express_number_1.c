/*
Given number N, count the number of ways to express N as sum of 1, 3 and 4.

(Brute-Force Approach)
Time Complexity : O(3^n)
Space Complexity : O(n)
*/

#include<stdio.h>

int countWays(int n)
{
	if(n<=2)
		return 1;
	
	if(n==3)
		return 2; 
		
	return  countWays(n-1) + 
		countWays(n-3) +
		countWays(n-4);
}

void main()
{
	int n = 10;
	
	printf("Total Ways = %d ", countWays(n));
}
