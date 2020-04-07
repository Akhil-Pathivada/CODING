/*
Given a sequence, find the length of the longest palindromic subsequence in it.

(Dynamic Programming)

Time Complexity : O(n^2)
Space Complexity : O(n^2)
*/

#include<stdio.h>
#include<string.h>

#define max(a,b)  (a > b) ? a : b

int LongestPalindromicSubsequence( char *str)
{
	int len = strlen(str);

	int i,j,ls, LPS[len][len];
	
	for(i=0; i<len; ++i)
		LPS[i][i] = 1;
	
	for(ls=2; ls<=len; ++ls)
	{	
		for(i=0; i<len-ls+1; ++i)
		{
			j = i + ls - 1;
			
			if (str[i] == str[j] && ls == 2) 
             			  LPS[i][j] = 2;			

			else if(str[i] == str[j])
				LPS[i][j]  = 2 + LPS[i+1][j-1];
				
			else
				LPS[i][j] = max(LPS[i+1][j] , LPS[i][j-1]);
		}
	}
	
	return LPS[0][len-1];
}

int main()
{
	char str[] = "GEEKSFORGEEKS";
	
	printf("Length of the Longest Palindromic Subsequence is = %d ", LongestPalindromicSubsequence(str) );
}
