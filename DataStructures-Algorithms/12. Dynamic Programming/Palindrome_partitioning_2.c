/*
Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition 
is a palindrome. Determine the fewest cuts needed for palindrome partitioning of a given string.

(Dynamic Programming)

Time Complexity : O(n^2)
Space Complexity : O(n^2)
*/
#include<stdio.h>
#include<string.h>
#include<stdbool.h>
#include<limits.h>

int min( int a, int b)
{
	return a < b ? a : b;
}

int minPartitions(char *str)
{
	int n = strlen(str);
	
	int C[n];
	
	bool P[n][n];
	
	int i, j, k, L;
	
	// Every substring of length-1 is Palindrome
	for(i=0; i<=n; ++i)
		P[i][i] = true;

	for(L=2; L<=n; ++L) // substring of length-L
	{
		for(i=0; i <= n-L; ++i) // possible starting indexes of each L-length substring
		{
			j = i+L-1; // ending index
			
			if(L == 2)
				P[i][j] = (str[i] == str[j]);
			else
				P[i][j] = (str[i] == str[j]) && P[i+1][j-1];
		}
	}
	
	for(i=0; i<n; ++i)
	{
		if(P[0][i] == true)
			C[i] = 0;
		else
		{
			C[i] = INT_MAX;
			
			for(j=0; j<i; ++j)
			{
				if(P[j+1][i] && 1+C[j] < C[i])
					C[i] = 1 + C[j];
			}
		}
	}
	
	return C[n-1];
}

int main() 
{ 
	char str[] = "ababbbabbababa"; 
    
    	printf("Min cuts needed for Palindrome Partitioning is = %d ", 
        		   minPartitions(str)); 
} 
