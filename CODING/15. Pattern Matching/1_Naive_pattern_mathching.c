/*
Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) 
that prints all occurrences of pat[] in txt[]. You may assume that n > m.

C program for Naive Pattern Searching algorithm....

Time Complexity : O((N-M+1) * O(M)) ..... O(n^2)
*/

#include<stdio.h>
#include<string.h>

void search( char *txt, char *pat)
{
	int N = strlen(txt);
	
	int M = strlen(pat);
	
	for(int i=0; i<=N-M; ++i)
	{
		int j;
		
		for(j=0; j<M; ++j)
			if(txt[i+j] != pat[j])
				break;
		
		if(j==M)
			printf(" Pattern found at index %d \n", i);
	}
}

void main()
{
	char txt[] = "AABAACAADAABAAABA";
	
	char pat[] = "AABA";
	
	search(txt,pat);
}


