/*
Given a distance 'dist', count total number of ways to cover the distance with 1, 2 and 3 steps.

(Dynamic Programming)

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>

int countWays( int dist)
{
	int table[dist+1];
	
	table[0] = 1;
	
	table[1] = 1;
	
	table[2] = 2;
	
	for(int i=3; i<=dist; ++i)
		table[i] = table[i-1] + table[i-2] + table[i-3];
	
	return table[dist];
}

void main()
{
	int dist = 5;
	
	printf("Total ways to Cover distance = %d ", countWays(dist));
}
