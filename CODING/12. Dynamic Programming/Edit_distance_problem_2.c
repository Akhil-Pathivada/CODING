/*
Given two strings str1 and str2 and below operations that can performed on str1.
Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
	1.Insert
	2.Remove
	3.Replace

(Dynamic Programming)

Time Complexity : O(m*n)
Space Complexity : O(m*n)
*/

#include<stdio.h> 
#include<string.h> 

int min( int a, int b, int c)
{
	return (a < b) ? (a<c ? a :c) : (b<c ? b : c);
}

int editDistance( char *str1, char *str2, int m, int n)
{
	int ED[m+1][n+1];
	
	for(int i=0; i<=m; ++i)
	{
		for(int j=0; j<=n; ++j)
		{
			if(i==0)
				ED[i][j] = j;
				
			else if(j==0)
				ED[i][j] = i;
				
			else if(str1[i] == str2[j])
				ED[i][j] = ED[i-1][j-1];
			
			else
				ED[i][j] = 1 + min( ED[i][j-1], ED[i-1][j], ED[i-1][j-1]);
		}
	}

	return ED[m][n];
}

int main() 
{ 
  
    char str1[] = "sunday"; 
    char str2[] = "saturday"; 
  
    printf(" Min. Operations required = %d ",editDistance( str1 , str2 , strlen(str1), strlen(str2))); 
  
} 

