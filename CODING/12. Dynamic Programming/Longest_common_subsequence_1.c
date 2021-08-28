/*
Given two sequences, find the length of longest subsequence present in both of them. 
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
The Sequences are of length : m, n

(Naive approach)

Time Complexity : O(2 ^ (n + m))

Space Complexity : O(n + m)
*/

#include<stdio.h>
#include<string.h>

#define max(a, b)  (a > b) ? a : b 

int getLCS(char X[], char Y[], int m, int n) {

	if(m == 0 || n == 0)
		return 0;
		
	if(X[m - 1] == Y[n - 1])	
		return 1 + getLCS(X, Y, m - 1, n - 1);
		
	return max(getLCS(X, Y, m, n - 1), getLCS(X, Y, m - 1, n));
}

int main() {	

	char X[] = "AGGTAB";
	char Y[] = "GXTXAYB";
	
	int m = strlen(X);
	int n = strlen(Y);
	
	printf(" Longest Common Subsequence : %d ", getLCS(X, Y, m, n));
}
