/*
Given a string and number of rows ‘n’.
Print the string formed by concatenating n rows when input string is written in row-wise Zig-Zag fashion.

Time Complexity : O(len)
Space Complexity : O(n*len)
*/

#include<string.h>
#include<stdio.h>
#include<stdbool.h>

void printZigZagConcat( char *str, int n)
{
	if(n==1)
	{
		puts(str);	
		
		return;
	}
	
	int len = strlen(str);
	
	char arr[n][len]; // array of strings
	
	memset(arr,0,sizeof arr);
	
	int row = 0;
	
	bool down = true;
	
	// storing into the strings
	for(int i=0; i<len; ++i)
	{
		arr[row][i] = str[i];
		
		if(row == n-1)
			down = false;
		
		if(row == 0)
			down = true;
		
		down ? ++row : --row;
	}
	
	// printing the concated string
	for(int i=0; i<n; ++i)
	{
		for(int j=0; j<len; ++j)
		{
			if(arr[i][j] != 0)
				putchar(arr[i][j]);
		}
	}
}

void main()
{
	char str[] = "GEEKSFORGEEKS";
	
	int n = 3;
	
	printZigZagConcat(str,n);	
}
