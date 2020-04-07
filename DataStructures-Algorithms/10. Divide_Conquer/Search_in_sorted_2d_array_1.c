/*
Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it. Otherwise, print “Not Found”. 
In the given matrix, every row and column is sorted in increasing order.

Time Complexity : O(n^2)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdbool.h>

bool searchElement( int arr[][4], int X, int n)
{
	for(int i=0; i<n; ++i)
	{
		for(int j=0; j<n; ++j)
		{
			if(arr[i][j] == X)
				return true;
		}
	}
	
	return false;
} 

void main()
{
	int arr[4][4] = { { 10, 20, 30, 40 }, 
    		      	{ 15, 25, 35, 45 }, 
             	      	{ 27, 29, 37, 48 }, 
       		      	{ 32, 33, 39, 50 } };
	int X = 50;
      
      	printf( searchElement(arr, X, 4) ? "Element Found" : " Not Found" );
}
