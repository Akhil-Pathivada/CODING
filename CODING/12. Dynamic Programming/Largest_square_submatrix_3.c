/*
Given a Binary Matrix, find the largest square submatrix with all 1's.

(Dynamic Programming)

Time Complexity : O(m * n)
Space Complexity : O(1).... computing and storing results in same matrix
*/

#include<stdio.h>

#define N 4
#define R 6
#define C 5


int min(int a, int b, int c) {

	return (a < b) ? (a < c ? a : c) : (b < c ? b : c);
}

void largestSquareMatrix(int M[R][C]) {

	int i, j, maxLen = M[0][0];

	for(i = 1; i < R; ++i) {

		for(j = 1; j < C; ++j) {
			//if element is '1'
			if(M[i][j] == 1) {

				M[i][j] = 1 + min(M[i-1][j], M[i-1][j-1], M[i][j-1]);

				if(M[i][j] > maxLen) {
					maxLen = M[i][j];
				}
			}
			// if element is '0'
			else {
				M[i][j] = 0;	
			}
		}
	}

	// printing the solution
	printf("Length of largest square matrix with all ones = %d", maxLen);
}

int main() {

	int M[R][C] = {	{0, 1, 1, 0, 1},
                 	{1, 1, 0, 1, 0},
                	{0, 1, 1, 1, 0},
                	{1, 1, 1, 1, 0},
                	{1, 1, 1, 1, 1},
                	{0, 0, 0, 0, 0}};
	
	largestSquareMatrix(M);
}
