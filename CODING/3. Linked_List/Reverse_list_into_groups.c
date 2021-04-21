/*
Reverse a Linked List in groups of given size 'K'

Time Complexity : O(n)
Space Complexity  : O(n)
*/

#include<stdio.h>
#include<stdlib.h>

struct node
{	
	int data;
	struct node *next;
};

struct node* newNode(int data)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->next = NULL;
	
	return nn;
}

struct node *Reverse(struct node *head, int K)
{
	struct node *prevPtr, *currPtr, *nextPtr;
	
	prevPtr = NULL;
	
	currPtr = head;
	
	for(int count=0; currPtr && count < K; ++count)
	{
		nextPtr = currPtr->next;
		
		currPtr->next = prevPtr;
		
		prevPtr = currPtr;
		
		currPtr = nextPtr;
	}
	
	if(nextPtr)
		head->next = Reverse(nextPtr,K);
	
	return prevPtr;
}

void main()
{
	struct node *head = newNode(1);
	head->next = newNode(2);
	head->next->next = newNode(3);
	head->next->next->next = newNode(4);
	head->next->next->next->next = newNode(5);
	head->next->next->next->next->next = newNode(6);
	head->next->next->next->next->next->next = newNode(7);
	head->next->next->next->next->next->next->next = newNode(8);
	
	int K = 3;
	
	head = Reverse(head,K);
	
	for( ; head; head=head->next)
		printf(" %d->",head->data);
}
