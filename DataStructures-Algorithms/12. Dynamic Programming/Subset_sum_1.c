/*
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.

Time Complexity : O(2^n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdbool.h>

bool isSubsetSum( int set[], int sum, int n)
{
	if(!sum)
		return true;
	
	if(!n && sum)
		return false;
	
	if(set[n-1] > sum)
		return isSubsetSum(set, sum, n-1);
		
	return isSubsetSum(set, sum-set[n-1], n-1) || isSubsetSum(set, sum, n-1);
}

void main()
{
	int set[] = {3, 34, 4, 12, 5, 2};
	
	int sum = 9; 
	
	int n = sizeof(set)/sizeof(*set);
	
	printf( isSubsetSum(set,sum,n) ? " YES " : " NO ");
}
