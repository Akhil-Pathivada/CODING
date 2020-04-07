/*
(Dynamic Programming Approach)

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>

int countFriendPairings(int n)
{
	int table[n+1];
	
	for(int i=0; i<=n; ++i)
	{
		if(i <= 2)
			table[i] = i;
			
		else
			table[i] = table[i-1] + ((i-1) * table[i-2]); 	
	}
	
	return table[n];	
}

void main()
{
	int n = 4;
	
	printf(" Total no. of ways = %d ", countFriendPairings(n));
}
