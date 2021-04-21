/*
Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 0’s.

(Dynamic Programming)

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>

int countBitStrings(int N)
{
	int temp[N+1];
	
	temp[1] = 2;
	
	temp[2] = 3;
	
	for(int i=3; i<=N; ++i)
		temp[i] = temp[i-1] + temp[i-2];
		
	return temp[N]; 
}

void main()
{
	int N = 4;
	
	printf(" Bit Strings without consective 0's : %d ", countBitStrings(N));
}
