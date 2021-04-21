/*
Given a Binary Matrix, find the largest square submatrix with all 1's.

(Dynamic Programming)

Time Complexity : O(n^2)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdbool.h>

#define N 4

int Min( int a, int b, int c)
{
	return (a < b) ? ( a < c ? a : c ) : ( b < c ? b : c );
}

void printSolution( int mat[N][N], int row, int col, int len)
{
	for(int i=row; i > row-len; --i)
	{
		for(int j=col; j > col-len; --j)
			printf(" %d ",mat[i][j]);
			
		printf("\n");
	}
}

int largestSquareMatrix( int matrix[N][N])
{
	int i,j,maxLen=1;
	
	for(i=1; i<N; ++i)
	{
		for(j=1; j<N; ++j)
		{
			if(matrix[i][j])
				matrix[i][j] = 1 + Min(matrix[i-1][j], matrix[i-1][j-1], matrix[i][j-1]);
				
			else
				matrix[i][j] = 0;	
		}
	}
	
	// getting the maxLength matrix
	for(i=0; i<N; ++i)
		for(j=0; j<N; ++j)
			maxLen = matrix[i][j] > maxLen ? matrix[i][j] : maxLen;

	return maxLen;
}

void main()
{
	int matrix[N][N] = {{1,1,1,1},
			    {0,0,1,1},
		            {1,1,1,1},
		            {0,1,1,1}};
	
	printf(" Largest square Submatrix : %d ", largestSquareMatrix(matrix));
}
