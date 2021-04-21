/*
Given a distance 'dist', count total number of ways to cover the distance with 1, 2 and 3 steps.

(Brute-Force Method)

Time Complexity : O(3^n)
Space Complexity : O(n)
*/

#include<stdio.h>

int countWays( int dist)
{
	if(dist < 0)
		return 0;
	
	if(dist == 0)
		return 1;
	
	return countWays(dist-1) +
               countWays(dist-2) + 
               countWays(dist-3);
}

void main()
{
	int dist = 5;
	
	printf("Total ways to Cover distance = %d ", countWays(dist));
}
