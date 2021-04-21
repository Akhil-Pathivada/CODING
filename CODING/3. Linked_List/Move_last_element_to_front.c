/*
Write a function that moves the last element to the front in a given Singly Linked List. 
For example, if the given Linked List is 1->2->3->4->5, then the function should change the list to 5->1->2->3->4.

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdlib.h>
#include<stdio.h>

struct node 
{
	int data;
	struct node *next;
};

void Push( struct node **head, int data)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->next = *head;
	
	*head = nn;
}

void moveLastToFront(struct node **head_addr)
{
	if(!*head_addr || !(*head_addr)->next)
		return;
	
	struct node *prev, *curr = *head_addr;
	
	for( ; curr->next; curr=curr->next)
		prev = curr;
	
	prev->next = NULL;
	
	curr->next = *head_addr;
	
	*head_addr = curr;
}

void printList(struct node *curr)
{
	for( ; curr; curr=curr->next)	
		printf(" %d->",curr->data);
}

void main()
{
	struct node *head = NULL;
	
	Push(&head,6);
	Push(&head,5);
	Push(&head,4);
	Push(&head,3);
	Push(&head,2);
	Push(&head,1);
	
	printList(head);
	
	moveLastToFront(&head);
	
	printList(head);
}
