/*
Given a Binary Matrix, find the largest square submatrix with all 1's.

(Dynamic Programming)

Time Complexity : O(m * n)
Space Complexity : O(m * n)... computing and storing results in another matrix
*/

#include<stdio.h>

#define N 4
#define R 6
#define C 5


int min(int a, int b, int c) {

	return (a < b) ? (a < c ? a : c) : (b < c ? b : c);
}

void largestSquareMatrix(int M[R][C]) {

	int i, j, S[R][C] = {0};
	// filling first row with original values
	for(i = 0; i < N; ++i) {
		S[i][0] = M[i][0];
	}
	// filling first colomn with original values	
	for(j = 0; j < N; ++j) {
		S[0][j] = M[0][j];
	}
	
	for(i = 1; i < R; ++i) {

		for(j = 1; j < C; ++j) {
			//if element is '1'
			if(M[i][j] == 1) {
				S[i][j] = 1 + min(S[i-1][j], S[i-1][j-1], S[i][j-1]);
			}
			// if element is '0'
			else {
				S[i][j] = 0;	
			}
		}
	}

	int max_i = 0, max_j = 0, max_of_s = S[0][0];
	// getting the max Length of result matrix
	for(i = 0; i < R; ++i) {

		for(j = 0; j < C; ++j) {

			if(S[i][j] > max_of_s) {

				max_of_s = S[i][j];
				max_i = i;
				max_j = j;
			}
		}
	}
	// printing the solution
	for(i = max_i; i > max_i - max_of_s; --i) {

		for(j = max_j; j > max_j - max_of_s; --j) {

			printf(" %d", M[i][j]);
		}	
		printf("\n");
	}
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
