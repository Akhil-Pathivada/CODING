/*
Given a sequence of matrices, find the most efficient way to multiply these matrices together.
The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.

(Dynamic Programming - Bottom Up approach)

Time Complexity : O(n^3)
Space Complexity : O(n^2)
*/

#include<stdio.h>
#include<limits.h>

int getMinMultiplications( int p[], int i, int n)
{
	int mat[n][n];
	
	for(int i=1; i<n; ++i)
		mat[i][i]=0;
		
		
	// 'l' is length of subproblem	
	for(int l=2; l<n; ++l)
	{
		for( i=1; i < n-l+1 ;++i)
		{
			int j = i+l-1;
			
			mat[i][j] = INT_MAX;
			
			for(int k=i ;k<j ;++k)
			{
				int count = mat[i][k] + mat[k+1][j] + p[i-1]*p[k]*p[j];
				
				mat[i][j] = count < mat[i][j] ? count : mat[i][j];
			}
		}
	}
	
	return mat[1][n-1];
}

void main()
{
	int arr[] = {1,2,3,4,3};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	printf(" Min. multiplications needed : %d ", getMinMultiplications(arr,1,n));
}
