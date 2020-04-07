/*
Given an array with both +ive and -ive integers, return a pair with highest product.

Time Complexity : O(n^2)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<limits.h>

void maxProductPair( int *arr, int n)
{
	int a, b, maxProd = 1;	
	
	for(int i=0; i<n; ++i)
	{
		for(int j=i+1; j<n; ++j)
		{
			int prod = arr[i]*arr[j];
			
			if(prod > maxProd)
			{
				maxProd = prod;
				
				a = arr[i];
				
				b = arr[j];
			}
		}
	}

	printf(" Max. Product Pair = (%d,%d)", a,b);
}

void main()
{
	int arr[] = {1,4,3,6,-9,7,0,5,-2,-5};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	maxProductPair(arr,size);
}
