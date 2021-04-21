/*
Program to find the middle node of the Linked List without using 'Count' variable

Time Complexity : O(n)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *next;
}*head,*rear,*nn;

void Insert(struct node *nn)
{
	if(head==NULL) 
		head=rear=nn;
	else
	{
		rear->next=nn;
		rear=nn;
	}
}

void Display(struct node *cur)
{
	for( ;cur; cur=cur->next)
		printf(" %d->",cur->data);
}

void findMiddle(struct node *head)
{
	struct node *slow,*fast;

	slow=fast=head;

	while(fast&&fast->next)
	{
		slow=slow->next;
		fast=fast->next->next;
	}

	printf("\nMiddle Element :: %d ",slow->data);
}

int main()
{
	int n,ch;
	do
	{
		printf("\n\t1.Insert");
		printf("\n\t2.Display");
		printf("\n\t3.Find Middle Node");
		printf("\n\nEnter U R Choice :: ");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:
				nn=(struct node*)malloc(sizeof(struct node));
				printf("\nEnter Node to insert :: ");
				scanf("%d",&nn->data);
				nn->next=NULL;
				Insert(nn);
				break;
			case 2:
				Display(head);
				break;
			case 3:
				findMiddle(head);
				break;
		}
	}
	while(ch<4);
}
