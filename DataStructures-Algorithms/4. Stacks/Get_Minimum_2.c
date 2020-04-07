// Design a STACK such that getMinimum() should be O(1)
// Space Complexity :: O(1) 
#include<stdio.h>
#define MAX 6
int stack[MAX],top=-1,min=9999;
void Push(int val)
{
	if(top==MAX-1)
		printf("\n** STACK is full **");
	else
	{
		if(val>min)
			stack[++top]=val;
		else
			stack[++top]=val-min,min=val;
	}
}
int Pop()
{
	if(top==-1) return -1;
	else
	{
		if(stack[top]>-1)
			return stack[top--];
		else
		{
			int temp=min;
			min-=stack[top--];
			return temp;
		}	
	}
}
int getMinimum()
{
	return min;
}
void main()
{
	int val,ch;
	do
	{
		printf("\n\t1.Push");
		printf("\n\t2.Pop");
		printf("\n\t3.Get_Minimum");
		printf("\n Enter U R Choice :: ");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1 : 
				printf("\n Enter the element to Push :: ");
				scanf("%d",&val);
				Push(val);
				break;
			case 2:
				printf("\n** Popped Element :: %d **\n",Pop());
				break;
			case 3 :
				printf("\n** Minimum Element :: %d **\n",getMinimum());	
				break;
		}
	}while(ch<4);	
}
