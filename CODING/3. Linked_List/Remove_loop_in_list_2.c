/*
Removing the Loop in the Linked List

Method-2
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

void removeLoop( struct node *head, struct node *loopNode)
{
	struct node *ptr1, *ptr2;
	
	ptr1 = ptr2 = loopNode;
	
	int k = 1;
	
	while(ptr2->next != ptr1)
	{
		k++;
		
		ptr2 = ptr2->next;
	}
	
	// Keep ptr1 at head && ptr2 at k nodes after head
	ptr1 = ptr2 = head;
	
	for(int i=0; i<k; ++i)
		ptr2 = ptr2->next;
		
	while(ptr1 != ptr2)
	{
		ptr1 = ptr1->next;
		
		ptr2 = ptr2->next;
	}
	
	while(ptr2->next != ptr1)
		ptr2 = ptr2->next;
	
	ptr2->next = NULL;
	
	printf(" Loop was successfully removed ");
}

struct node *getLoopNode(struct node *head)
{
	struct node *slowPtr, *fastPtr;
	
	slowPtr = fastPtr = head;
	
	while(fastPtr && fastPtr->next)
	{	
		fastPtr = fastPtr->next->next;
		
		slowPtr = slowPtr->next;
		
		if(slowPtr == fastPtr)
			return slowPtr;
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
	
	struct node *loopNode = getLoopNode(head);
	
	if(loopNode)
		removeLoop(head, loopNode);	
}
