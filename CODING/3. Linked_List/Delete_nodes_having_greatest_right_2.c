/*
Delete nodes which have a greater value on right side

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>
#include<limits.h>

struct node
{
	int data;
	struct node *next;
};

struct node* newNode(int val)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->next = NULL;
	
	return nn;
};

void Reverse(struct node **head_addr)
{
	struct node *currPtr, *prevPtr, *nextPtr;	
	
	currPtr = *head_addr;
	
	prevPtr = NULL;
	
	while(currPtr)
	{
		nextPtr = currPtr->next;
		
		currPtr->next = prevPtr;
		
		prevPtr = currPtr;
		
		currPtr = nextPtr;	
	}
	
	*head_addr = prevPtr;
}

void removeNode(struct node *curr)
{
	curr->data = curr->next->data;
	
	curr->next = curr->next->next;
}

struct node *deleteNodes(struct node *head)
{
	Reverse(&head);
	
	int max = head->data;
	
	struct node *curr = head;	
	
	while(curr && curr->next)
	{
		if(curr->next->data < max)
			curr->next = curr->next->next;
		else
		{
			curr = curr->next;
			
			max = curr->data;
		}
	}
	
	Reverse(&head);
	
	return head;
}

void printList(struct node *head)
{
	for( ;head; head=head->next)
		printf(" %d->",head->data);
}

void main()
{
	struct node *head = newNode(120);
	head->next = newNode(13);
	head->next->next = newNode(7);
	head->next->next->next = newNode(2);
	head->next->next->next->next = newNode(15);
	
	printList(head);
	
	printList(deleteNodes(head));
}
