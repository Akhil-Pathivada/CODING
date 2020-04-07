/*
Given a sequence, find the length of the longest palindromic subsequence in it.

(Brute-Force approach)

Time Complexity : O(n * 2^n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<string.h>

#define max(a,b)  (a > b) ? a : b

int LPS( char *str, int start, int end)
{
	if(start > end)
		return 0;
	
	if(start == end)
		return 1;
	
	if(str[start] == str[end]) 
		return 2 + LPS(str, start+1, end-1);
		
	return max( LPS(str, start+1, end) , LPS(str, start, end-1) );
}

int main()
{
	char str[] = "GEEKSFORGEEKS";
	
	printf("Length of the Longest Palindromic Subsequence is = %d ", LPS(str,0, strlen(str)-1) );
}
