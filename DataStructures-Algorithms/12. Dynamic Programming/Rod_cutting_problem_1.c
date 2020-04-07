/*
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces.

(Brute-Force Method)

Time Complexity : O(n^n)
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
	if(!n)
		return 0;
	
	int maxVal = INT_MIN;
	
	for(int i=0; i<n; ++i)
		maxVal = max(maxVal, price[i] + cutRod(price,n-i-1));
		
	return maxVal;
}

void main()
{
	int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	printf(" Max. obtainable value = %d ", cutRod(arr,n));
}
