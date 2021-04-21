/*
A memory efficient version of Doubly Linked List can be created using only one space for address field with every node. 
This memory efficient Doubly Linked List is called XOR Linked List or Memory Efficient as the list uses bitwise XOR operation to save space for one address.
In the XOR linked list, instead of storing actual memory addresses, every node stores the XOR of addresses of previous and next nodes.

*/

#include<stdio.h>
#include<stdlib.h>
#include<inttypes.h>

struct node
{
	int data;
	struct node *npx;
};

struct node *XOR( struct node *A, struct node *B)
{
	return (struct node*)((uintptr_t)(A) ^ (uintptr_t)(B)); 
}

void insert( struct node **head_addr, int data)
{
	struct node *newnode = (struct node*)malloc(sizeof(struct node));
	
	newnode->data = data;
	
	newnode->npx = XOR(*head_addr,NULL);
	
	if(*head_addr)
	{
		struct node *next = XOR((*head_addr)->npx,NULL);
		
		(*head_addr)->npx = XOR(newnode,next);
	}
	
	*head_addr = newnode;
}

void printList(struct node *curr)
{
	struct node *prev, *next;
	
	prev = NULL;
	
	while(curr)
	{	
		printf(" %d->",curr->data);
		
		next = XOR(prev,curr->npx);
		
		prev = curr;
		
		curr = next;	
	}
}

void main()
{
	struct node *head = NULL;
	
	insert(&head,5);
	insert(&head,4);
	insert(&head,3);
	insert(&head,2);
	insert(&head,1);
	
	printList(head);
}
