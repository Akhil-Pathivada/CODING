/*
Given a sequence, find the length of the longest palindromic subsequence in it.

(Using LCS)

Time Complexity : O(n^2)
Space Complexity : O(n^2)
*/

#include<stdio.h>
#include<string.h>

#define max(a,b)  (a > b) ? a : b

int LCS( char X[], char Y[], int m, int n)
{
	int mat[m+1][n+1];
		
	for(int i=0; i<=m; ++i)
	{
		for(int j=0; j<=n; ++j)
		{
			
			if(i==0 || j==0)
				mat[i][j] = 0;
			
			else if(X[i-1] == Y[j-1])
				mat[i][j] = 1 + mat[i-1][j-1];
			
			else
				mat[i][j] = max(mat[i-1][j], mat[i][j-1]);
		}
	}
	
	return mat[m][n];	
}

void Reverse( char *str, int start, int end)
{
	if(start > end)
		return;
		
	char temp = str[start];
		
	str[start] = str[end];
	
	str[end] = temp;
	
	Reverse(str, start+1, end-1);
}

int LongestPalindromicSubsequence( char *X)
{
	int len = strlen(X);
	
	char Y[len];
	
	strcpy(Y,X);
	
	Reverse(Y,0,len-1);
		
	return LCS(X,Y,len,len);	
}

int main()
{
	char str[] = "GEEKSFORGEEKS";
	
	printf("Length of the Longest Palindromic Subsequence is = %d ", LongestPalindromicSubsequence(str) );
}
