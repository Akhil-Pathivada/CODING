/*
Given a string S consisting of lowercase characters, you have to delete the minimum number of characters from S,
so that every letter in S appears a unique number of times.

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#define TOTAL_CHARS 26
#include<limits.h>
#include<string.h>

int minDeletions( char *str, int n)
{
	int i, min, freq[TOTAL_CHARS]={0};
		
	for(i=0; i<n; ++i)
		freq[str[i]-'a']++;
		
	min = INT_MAX;
		
	for(i=0; i<TOTAL_CHARS; ++i)
	{
		if(freq[i] && freq[i] < min)
			min = freq[i];
	}
	
	int deletions = 0;
	
	for(i=0; i<TOTAL_CHARS; ++i)
	{
		if(freq[i] && freq[i] > min)
			deletions += freq[i]-min;
	}
	
	return deletions;
}

void main()
{
	char str[] = "geeksforgeeks	";
	
	printf("Min. deletions needed : %d ", minDeletions(str,strlen(str)) );
}
