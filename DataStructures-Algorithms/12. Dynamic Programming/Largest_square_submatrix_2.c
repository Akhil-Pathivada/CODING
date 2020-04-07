/*
Given a Binary Matrix, find the largest square submatrix with all 1's.

(Dynamic Programming)

Time Complexity : O(n^2)
Space Complexity : O(n^2)
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

void largestSquareMatrix( int matrix[N][N])
{
	int i,j, temp[N][N];
	
	for(i=0; i<N; ++i)
		temp[i][0] = matrix[i][0];
		
	for(j=0; j<N; ++j)
		temp[0][j] = matrix[0][j];
	
	for(i=1; i<N; ++i)
	{
		for(j=1; j<N; ++j)
		{
			if(matrix[i][j])
				temp[i][j] = 1 + Min(temp[i-1][j], temp[i-1][j-1], temp[i][j-1]);
				
			else
				temp[i][j] = 0;	
		}
	}

	int max_i, max_j, maxLen = temp[0][0];
	
	// getting the maxLength matrix
	for(i=0; i<N; ++i)
	{
		for(j=0; j<N; ++j)
		{
			maxLen = temp[i][j] > maxLen ? temp[i][j] : maxLen;
			
			max_i = i;
			
			max_j = j;
		}
	}
	
	printSolution(matrix,max_i,max_j,maxLen);
}

void main()
{
	int matrix[N][N] = {{1,1,1,1},
			    {0,0,1,1},
		            {1,1,1,1},
		            {0,1,1,1}};
	
	largestSquareMatrix(matrix);
}
