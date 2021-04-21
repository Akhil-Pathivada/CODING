/*
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces.

(Dynamic Programming)

Time Complexity : O(n^2)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<limits.h>

int max(int a,int b)
{
	return (a>b) ? a : b;
}

int cutRod( int *price, int n)
{
	int val[n+1];
	
	val[0] = 0;
	
	int i,j;
	
	for(i=1; i<=n; ++i)
	{
		int maxVal = INT_MIN;
		
		for(j=0; j<i; ++j)
			maxVal = max(maxVal ,price[j] + val[i-j-1]);
			
		val[i] = maxVal;
	}
	
	return val[n];
}

void main()
{
	int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	printf(" Max. obtainable value = %d ", cutRod(arr,n));
}
