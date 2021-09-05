/*
Program to get the Nth Fibanocci number......

(Dynamic Programming)

Time Complexity : O(n)
Space Complexity : O(n)

*/
#include<stdio.h>

int getNthFibanocci(int n) {

	int fibo[n];
	
	fibo[0] = 0;
	fibo[1] = 1;
	
	for(int i = 2; i <= n; ++i) {

		fibo[i]  = fibo[i-1] + fibo[i-2]; 
	}
		
	return fibo[n];
}

int main() {

	int n = 9;
	
	printf(" %d ", getNthFibanocci(n));
}
