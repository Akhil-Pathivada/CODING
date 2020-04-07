/*
(Space Optimized Solution)

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>

int countFriendPairings(int n)
{
	
	int a = 1;
	
	int b = 2;
	
	for(int i=3; i<=n; ++i)
	{
		int c = b + ((i-1) * a);
		
		a = b;
		
		b = c;
	}
	
	return b;	
}

void main()
{
	int n = 4;
	
	printf(" Total no. of ways = %d ", countFriendPairings(n));
}
