/* Program for Stock Span problem....

Time Complexity : O(n)
Space Complexity : O(n)....(for Stack)
*/
#include<stdio.h>

int top=-1;

void push(stack,span,n)
int stack[],span,n;
{
	if(top==n)
		printf("\n ** Stack is full **\n");
	else
		stack[++top]=span;
}

int isStackEmpty()
{
	return (top==-1);
}

void pop()
{
	top--;
}

void evaluateSpan(price,stock,n)
int price[],stock[],n;
{
	int stack[n];

	for(int i=0; i<n; i++)
	{
		while(!isStackEmpty() && price[stack[top]] <= price[i])
			pop();

		stock[i] = isStackEmpty() ? i : (i-stack[top]-1);

		push(stack,i,n);
	}
}

void printSpan(stock,n)
int stock[],n;
{
	for(int i=0;i<n;i++)
		printf(" %d,",stock[i]);
}

int main()
{
	int price[] = {10, 4, 5, 90, 120, 80};
	
	int stock[6];

	evaluateSpan(price,stock,6);

	printSpan(stock,6);
}
