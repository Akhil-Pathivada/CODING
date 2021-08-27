/*
Ugly numbers are numbers whose only prime factors are 2, 3 or 5. 
Given a number n, the task is to find K’th Ugly number.

(Dynamic Programming)

Time Complexity : O(K)
Space Complexity : O(K)
*/

#include<stdio.h>
#include<stdlib.h>

int min(int a, int b, int c) {

	return a < b ? ( a < c ? a : c) : ( b < c ? b : c);
}

int getKthUglyNumber(int K) {

	int *ugly = (int*)malloc(sizeof(int) * K);
	int i2 = 0, i3 = 0, i5 = 0;
	int nextMultipleOf2 = 2, nextMultipleOf3 = 3, nextMultipleOf5 = 5;
	
	ugly[0] = 1;
	
	for(int i = 1; i < K; ++i) {

		int nextUglyNumber = min(nextMultipleOf2, nextMultipleOf3, nextMultipleOf5);
		ugly[i] = nextUglyNumber;
		
		if(nextUglyNumber == nextMultipleOf2) {

			++i2;
			nextMultipleOf2 = ugly[i2] * 2;
		}

		if(nextUglyNumber == nextMultipleOf3) {

			++i3;
			nextMultipleOf3 = ugly[i3] * 3;
		}

		if(nextUglyNumber == nextMultipleOf5) {

			++i5;
			nextMultipleOf5 = ugly[i5] * 5;
		}		
	}
	
	return ugly[K - 1];
}

int main() {

	int K = 12;
	printf(" %d th Ugly Number : %d ", K, getKthUglyNumber(K));
}
