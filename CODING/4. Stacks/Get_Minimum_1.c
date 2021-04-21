/*
Design a STACK such that getMinimum() should be O(1)

Space Complexity : O(n) ....because of one extra STACK
*/

#include<stdio.h>
#define MAX 6
#include<limits.h>

int stack[MAX], temp[MAX];

int top1 = -1, top2 = -1;

int min = INT_MAX;

void Push(int data)
{
	if(top1 == MAX)
		printf("**STACK is full **");
	else
		stack[++top1]=data;
	
}
void Push2(int data)
{
	min = data < min ? data : min;
	
	temp[++top2] = min;
}

int Pop(int *t)
{
	if(*t == -1)
		printf("\n** STACK is empty **");
	else
		return --*t;
}

int getMinimum()
{
	return temp[Pop(&top2)];
}

void printStack()
{
	for(int i=top1; i>=0; --i)
		printf(" %d,",stack[i]);
}

int main()
{
	int val;
	
	printf("\nEnter the Stack :");
	
	for(int i=0; i<MAX; i++)
	{
		scanf("%d",&val);
		
		Push(val);
		Push2(val);
	}
	
	printStack();
	
	printf("** Min. value = %d **",getMinimum());
}
