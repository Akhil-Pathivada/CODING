/*
Removing the Loop in the Linked List

Method-3
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node
{
	int data;
	struct node *next;
};

void Push(struct node **head, int data)
{
	struct node *temp = (struct node*) malloc(sizeof(struct node));
	
	temp->data = data;
	
	temp->next = (*head);
	
	*head = temp;
}

void removeLoop( struct node *slowPtr, struct node *fastPtr)
{
	while(slowPtr->next != fastPtr->next)
	{
		slowPtr = slowPtr->next;
		
		fastPtr = fastPtr->next;
	}
	
	fastPtr->next = NULL;
	
	printf(" Loop was successfully removed ");
}

struct node *getFastPtr(struct node *head)
{
	struct node *slowPtr, *fastPtr;
	
	slowPtr = fastPtr = head;
	
	while(fastPtr && fastPtr->next)
	{	
		fastPtr = fastPtr->next->next;
		
		slowPtr = slowPtr->next;
		
		if(slowPtr == fastPtr)
			return fastPtr;
	}
	
	return NULL;
}

void main()
{
	struct node *head = NULL;
	
	Push(&head, 10);
	Push(&head, 20);
	Push(&head, 30);
	Push(&head, 40);
	Push(&head, 50);
	
	head->next->next->next->next = head->next; // creating the loop
	
	struct node *fastPtr = getFastPtr(head);
	
	if(fastPtr)
		removeLoop(head, fastPtr);	
}
