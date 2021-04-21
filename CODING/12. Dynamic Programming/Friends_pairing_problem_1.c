/*
Given n friends, each one can remain single or can be paired up with some other friend. 
Each friend can be paired only once.
Find out the total number of ways in which friends can remain single or can be paired up. 

Input  : n = 3
Output : 4

Explanation
{1}, {2}, {3} : all single
{1}, {2, 3} : 2 and 3 paired but 1 is single.
{1, 2}, {3} : 1 and 2 are paired but 3 is single.
{1, 3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1, 2} and {2, 1} are considered same.

(Brute-Force Approach)

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>

int countFriendPairings(int n)
{
	if(n <= 2)
		return n;
	
	else
		return 	countFriendPairings(n-1) + ((n-1) * countFriendPairings(n-2));
}

void main()
{
	int n = 4;
	
	printf(" Total no. of ways = %d ", countFriendPairings(n));
}
