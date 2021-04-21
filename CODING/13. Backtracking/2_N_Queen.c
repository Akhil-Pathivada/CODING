/*
Solve N Queen Problem using Backtracking 

Time Complexity : Unable to analyse.....but lesser than O(n! * n^2)

*/

#include<stdio.h>
#include<stdbool.h>

#define N 4

void printSolution( int board[N][N])
{
	for(int i=0; i<N; ++i)
	{
		for(int j=0; j<N; ++j)
			printf(" %d,", board[i][j]);
			
		printf("\n");
	}
}

bool isSafe( int board[N][N], int row, int col)
{
	int i,j;

	// Searching the entire row
	for(i=0; i<col; ++i)
		if(board[row][i])
			return false;
			
	// Searching the upper diagnol on left side
	for(i=row, j=col; i>=0 && j>=0 ; --i,--j)
		if(board[i][j])
			return false;
			
	// Searching the lower diagnol on right side
	for(i=row, j=col; i<N && j>=0; ++i,--j)
		if(board[i][j])
			return false;
	
	return true;
}

bool solveNQueen( int board[N][N], int col)
{
	if(col >= N)
		return true;
		
	for(int index=0; index<N; ++index)
	{
		if(isSafe(board,index,col))
		{
			board[index][col] = 1;
			
			if(solveNQueen(board,col+1))
				return true;
			
			board[index][col] = 0;
		}
	}
	
	return false;
}

void main()
{
	int board[N][N] = {{0,0,0,0},
				 {0,0,0,0},
				 {0,0,0,0},
				 {0,0,0,0}};
				 
	
	if(solveNQueen(board,0))
		printSolution(board);
	
	else
		printf("Solution doesn't exist");
}
