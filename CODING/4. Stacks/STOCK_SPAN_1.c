/* 
Program for Stock Span problem....

https://www.geeksforgeeks.org/the-stock-span-problem/

Time Complexity : O(n ^ 2)
Space Complexity : O(1)
*/

#include<stdio.h>

int top = -1;

void evaluateSpan(price,stock,n)
int price[], stock[], n;
{
	for(int i = 0; i < n; i++) {

		int j = i-1;

		for( ; j >= 0 && price[j] <= price[i]; --j);

		stock[i] = i - j - 1;
	}
}

void printSpan(stock,n)
int stock[],n;
{
	for(int i = 0; i < n; ++i)
		printf(" %d", stock[i]);
}

int main() {

	int price[] = {10, 4, 5, 90, 120, 80};
	
	int stock[6];

	evaluateSpan(price, stock, 6);

	printSpan(stock, 6);
}
