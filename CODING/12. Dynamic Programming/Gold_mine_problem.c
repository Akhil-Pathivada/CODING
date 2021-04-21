/*
Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. 
Initially the miner is at first column but can be at any row. He can move only (right->/right up /right down) that is from a given cell, 
the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. Find out maximum amount of gold he can collect. 

Time Complexity : O(m*n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<string.h>
#define MAX 4

int max( int a, int b)
{
	return a>b ? a : b;
}

int getMaxGold( int gold[][MAX])
{
	int m, n;
	
	m = n = MAX;
	
	for(int col=n-1; col>=0; --col)
	{
		int right, rightUp, rightDown;
		
		for(int row=0; row<m; ++row)
		{
			 right = (col==n-1) ? 0 : gold[row][col+1];
			 
			 rightUp = (col==n-1 || row==0) ? 0 : gold[row-1][col+1];
			 
			 rightDown = (col==n-1 || row==m-1) ? 0 : gold[row+1][col+1];
			 
			 gold[row][col] += max(right, max(rightUp, rightDown)); 
		}
	}
	
	int res = 0;
	
	for(int i=0; i<m; ++i)
		res = max( res, gold[i][0]);
	
	return res;
}

void main()
{
	int gold[MAX][MAX]={{10, 33, 13, 15},
                  	    {22, 21, 04, 1},
                  	    {5, 0, 2, 3},
                  	    {0, 6, 14, 2}};
                  	    
       printf("Max. Gold = %d ", getMaxGold(gold));
}
