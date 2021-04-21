/*
Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it. Otherwise, print “Not Found”. 
In the given matrix, every row and column is sorted in increasing order.

(Divide & Conquer)

Time Complexity : O(n)
Space Complexity : O(1)

*/

#include<stdio.h>
#include<stdbool.h>

bool searchElement( int (*arr)[4], int X, int i, int j, int n) // starts from top-right corner
{
	if(i>n || j<0)
		return false;
	
	if(arr[i][j] == X)
		return true;
	
	if(arr[i][j] < X)
		return searchElement(arr, X, ++i, j, n);
		
	return searchElement(arr, X, i, --j, n);
		
} 

void main()
{
	int arr[][4] = { { 10, 20, 30, 40 }, 
    		       { 15, 25, 35, 45 }, 
             	       { 27, 29, 37, 48 }, 
       		       { 32, 33, 39, 50 } };
	int X = 32;
	
      	int size = 4; //size of matrix
      	
      	printf( searchElement(arr, X, 0, --size, size) ? "Element Found" : " Not Found" );
}
