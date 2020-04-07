
//Program to Reverse a Doubly Linked List

struct node
{
	int data;
	struct node *prev, *next;
};

#include<stdio.h>
#include<stdlib.h>

void Insert( struct node **head_addr, int val)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->prev = NULL;
	
	nn->next = *head_addr;
	
	if(*head_addr)
		(*head_addr)->prev = nn;
	
	*head_addr = nn;
}

void ReverseList( struct node **head_addr)
{
	struct node *curr, *temp;
	
	curr = *head_addr;
	
	for( ; curr; curr = curr->prev)
	{
		temp = curr->prev;
		
		curr->prev = curr->next;
		
		curr->next = temp;
	}
	
	*head_addr = temp->prev;
}

void printList( struct node *curr)
{
	for( ; curr; curr=curr->next)
		printf(" %d,", curr->data);
}

void main()
{
	struct node *head = NULL;
	
	Insert(&head,10);
	Insert(&head,20);
	Insert(&head,30);
	Insert(&head,40);
	Insert(&head,50);
	
	printList(head);
	
	ReverseList(&head);
	
	printList(head);
}
