/*
There are n stairs, a person standing at the bottom wants to reach the top. 
The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.

(Dyanmic Programming)

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>

int countWays(int n)
{
	int temp[n+1];
	
	temp[1] = 1;
	
	temp[2] = 2;
	
	for(int i=3; i<=n; ++i)
		
		temp[i] = temp[i-1] + temp[i-2];
		
	return temp[n];
}

void main()
{
	int steps = 5;
	
	printf(" Total ways for the person to reach Top : %d ", countWays(steps));
}

