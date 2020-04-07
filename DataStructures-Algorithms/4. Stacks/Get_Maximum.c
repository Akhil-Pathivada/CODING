/*
Design a STACK such that getMaximum() should be O(1)

Space Complexity : O(1) 
*/

#include<stdio.h>
#include<limits.h>
#define MAX 6

int stack[MAX];

int top=-1;

int max = INT_MIN;

void Push(int val)
{
	if(top == MAX-1)
		printf("** Stack is full **");
	else
	{
		if(val < max)
			stack[++top] = val;
		else
		{
			stack[++top] = max-val;
			
			max = val;
		}
	}
}

int Pop()
{
	if(top == -1) 
		return -1;
	else
	{
		if(stack[top] > 1)
			return stack[top--];
		else
		{
			int temp = max;
			
			max += stack[top--];
			
			return temp;
		}	
	}
}
int getMaximum()
{
	return max;
}

void main()
{
	int val,ch;
	do
	{
		printf("\n\t1.Push");
		printf("\n\t2.Pop");
		printf("\n\t3.Get_Maximum");
		
		printf("\n Enter U R Choice :");
		scanf("%d",&ch);
		
		switch(ch)
		{
			case 1 : 
				printf("\n Enter the element to Push : ");
				scanf("%d",&val);
				Push(val);
				break;
			case 2:
				printf(" Popped Element = %d \n",Pop());
				break;
			case 3 :
				printf(" Maximum Element = %d \n",getMaximum());	
				break;
		}
	}while(ch<4);	
}
