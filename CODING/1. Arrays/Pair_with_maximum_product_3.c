/*
Given an array with both +ive and -ive integers, return a pair with highest product.

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<limits.h>

int max(int a,int b)
{
	return a>b ? a : b;
}

void maxProductPair( int *arr, int n)
{		
	int maxPos1, maxPos2;
	
	int minNeg1, minNeg2;
	
	maxPos1 = maxPos2 = INT_MIN;
	
	minNeg1 = minNeg2 = 0;
	
	for(int i=0; i<n; ++i)
	{
		if(arr[i] > maxPos1)
		{
			maxPos2 = maxPos1;
			
			maxPos1 = arr[i];
		}
		else if(arr[i] > maxPos2)
			maxPos2 = arr[i];
		
		if(arr[i] < minNeg1)
		{
			minNeg2 = minNeg1;
			
			minNeg1 = arr[i];
		}
		else if(arr[i] < minNeg2)
			minNeg2 = arr[i];
	}
	
	
	if(maxPos1*maxPos2 > minNeg1*minNeg2)
		printf(" Max. Product Pair = (%d,%d)", maxPos1,maxPos2);
	
	else
		printf(" Max. Product Pair = (%d,%d)", minNeg1,minNeg2);
}

void main()
{
	int arr[] = {1,4,3,6,-9,7,0,5,-2,-5};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	maxProductPair(arr,size);
}
