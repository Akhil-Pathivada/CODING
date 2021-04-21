/*
Given two sequences, find the length of longest subsequence present in both of them. 
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
The Sequences are of length : m,n

(Dynamic Programming - Bottom Up approach)

Time Complexity : O(m*n)

Space Complexity : O(n)
*/

#include<stdio.h>
#include<string.h>
#include<stdbool.h>

#define max(a,b)  (a > b) ? a : b 

int getLCS( char X[], char Y[], int m, int n)
{
	int mat[2][n+1];
	
	bool bi;
		
	for(int i=0; i<=m; ++i)
	{
		bi = i & 1;
		
		for(int j=0; j<=n; ++j)
		{
			
			if(i==0 || j==0)
				mat[bi][j] = 0;
			
			else if(X[i-1] == Y[j-1])
				mat[bi][j] = 1 + mat[1-bi][j-1];
			
			else
				mat[bi][j] = max(mat[1-bi][j], mat[bi][j-1]);
		}
	}
	
	return mat[bi][n];	
}

void main()
{	
	char X[] = "AGGTAB";
	char Y[] = "GXTXAYB";
	
	int m = strlen(X);
	int n = strlen(Y);
	
	printf(" Longest Common Subsequence : %d ", getLCS(X,Y,m,n));
}
