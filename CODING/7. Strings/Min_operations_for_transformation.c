/*
Given two strings A and B, the task is to convert A to B if possible. 
The only operation allowed is to put any character from A and insert it at front. 
Find if it’s possible to convert the string. If yes, then output minimum no. of operations required for transformation.

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<string.h>
#include<stdbool.h>
#define TOTAL_CHARS 256
#include<stdio.h>


bool checkLengths( char *A, char *B)
{
	return (strlen(A) == strlen(B));
}

bool countChars( char *A, char *B)
{
	int count[TOTAL_CHARS] = {0}; // constant space
	
	for( ; *A; ++A)
		count[*A]++;
	
	for( ; *B; ++B)
		count[*B]--;
	
	for(int i=0; i<TOTAL_CHARS; ++i)
		if(count[i])
			return false;
		
	return 	true;	
}

int searchChar( char *A, char ch)
{
	printf(" %c",ch);
	for(int i=0 ; A[i]; ++i)
		if(ch == A[i])
			return i;
}

int countOperations( char *A, char *B)
{
	bool flag = checkLengths(A,B);
	
	flag = countChars(A,B);
	
	if(!flag)
		return -1;
	
	int len = strlen(A);
	
	int i, j, moves=0;
	
	i = j = len-1;
	
	while(i>=0)
	{
		while(i>=0 && B[j] != A[i])
		{
			--i;
			
			++moves;
		}
			
		if(i>=0)
		{
			--i;
					
			--j;
		}		
	}
	
	return moves;
}

void main()
{ 
	char A[] = "EACBD";
	
	char B[] = "EABCD"; 
	
	printf(" Min. Operations to be needed are = %d ", countOperations(A,B));
}
