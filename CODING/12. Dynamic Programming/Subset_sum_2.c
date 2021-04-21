/*
Given a set of non-negative integers, and a value sum , determine if there is a mat of the given set with sum equal to given sum.

Time Complexity : O(n*sum)
Space Complexity : O(n*sum)
*/

#include<stdio.h>
#include<stdbool.h>

bool isSubsetSum( int set[], int sum, int n)
{
	bool mat[n+1][sum+1];
	
	for(int i=0; i<=n; ++i)
		mat[i][0] = true;
		
	for(int i=1; i<=sum; ++i)
		mat[0][i] = false;
	
	for(int i=1; i<=n; ++i)
	{
		for( int j=1; j<=sum; ++j)
		{
			if(set[i-1] > j)
				mat[i][j] = mat[i-1][j];
				
			else
				mat[i][j] = mat[i-1][j-set[i-1]] || mat[i-1][j];
		}
	}
	
	return mat[n][sum];
}

void main()
{
	int set[] = {3, 34, 4, 12, 5, 2};
	
	int sum = 9; 
	
	int n = sizeof(set)/sizeof(*set);
	
	printf( isSubsetSum(set,sum,n) ? " YES " : " NO ");
}
