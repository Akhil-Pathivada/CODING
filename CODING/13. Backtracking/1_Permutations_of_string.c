/*
C program to print all permutations of string with duplicates allowed 

Time Complexity : O(n*n!)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<string.h>

void swap( char *aptr, char *bptr)
{
	char temp = *aptr;
	*aptr = *bptr;
	*bptr = temp;
}

void permute( char *str, int l, int r)
{
	if(l == r)
	{
		printf(" %s,",str);
	
		return;
	}
	
	for(int i=l; i<=r; ++i)
	{
		swap(&str[l], &str[i]);
		
		permute(str, l+1, r);
		
		swap(&str[l], &str[i]); // Backtrack
	}
}

void main()
{
	char str[] = "ABC";
	
	int len = strlen(str);
	
	permute(str,0,len-1);
}
