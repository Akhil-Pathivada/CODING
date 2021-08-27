/*
Ugly numbers are numbers whose only prime factors are 2, 3 or 5. 
Given a number n, the task is to find K’th Ugly number.

We can't ananlyse Time Complexity....
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdbool.h>

int Divide(int a, int b) {

	while(a % b == 0) {

		a /= b;
	}
	return a;
}

bool isUgly(int num) {

	num = Divide(num, 2);
	num = Divide(num, 3);
	num = Divide(num, 5);
	
	return (num == 1) ? true : false;
}

int getKthUglyNumber(int K) {

	int i = 1;
	
	for(int count = 1; count <= K; ++i) {

		if(isUgly(i)) {

			++count;
		}
	}
		
	return i - 1;
}

int main() {

	int K = 12;
	printf(" %d th Ugly Number : %d ", K, getKthUglyNumber(K));
}
