/*
There are n stairs, a person standing at the bottom wants to reach the top. 
The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.

Time Complexity : O(2^n)
Space Complexity : O(n)
*/

#include<stdio.h>

int countWays(int n)
{
	if(n <= 1)
		return 1;
	
	return countWays(n-1) + countWays(n-2);
}

void main()
{
	int steps = 5;
	
	printf(" Total ways for the person to reach Top : %d ", countWays(steps));
}

