/* Program for Stock Span problem....


Time Complexity : O(n)
Space Complexity : O(n)....(for Stack)
*/
#include<stdio.h>

int top = -1;

void push(stack,span,n)
int stack[], span, n;
{
	if(top == n)
		printf("\n ** Stack is full **\n");
	else
		stack[++top] = span;
}

int isStackEmpty() {
	return (top == -1);
}

void pop() {
	top--;
}

void evaluateSpan(price, stock, n)
int price[], stock[], n;
{
	int stack[n];

	for(int i = 0; i < n; i++) {

		while(!isStackEmpty() && price[stack[top]] <= price[i])
			pop();

		stock[i] = isStackEmpty() ? i : (i - stack[top] - 1);

		push(stack, i, n);
	}
}

void printSpan(stock,n)
int stock[], n;
{
	for(int i = 0; i < n; ++i)
		printf(" %d,",stock[i]);
}

int main() {

	int price[] = {100, 80, 60, 70, 60, 75, 85};
	
	int stock[7];

	evaluateSpan(price, stock, 7);

	printSpan(stock, 7);
}
