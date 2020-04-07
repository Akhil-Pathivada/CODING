/*
Write a function detectAndCountLoop() that checks whether a given Linked List contains loop and if loop is present then returns count of nodes in loop.

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

int detectAndCountLoop(struct node *head)
{
	struct node *slowPtr, *fastPtr;
	
	slowPtr = fastPtr = head;
	
	while(fastPtr && fastPtr->next)
	{
		slowPtr = slowPtr->next;
		
		fastPtr = fastPtr->next->next;
		
		if(slowPtr == fastPtr)
			break;
	}
	
	if(!fastPtr || !fastPtr->next)
	{
		printf(" No Loop exists.....");
		
		return 0;
	}
	
	int count = 1;
	
	while(slowPtr->next != fastPtr)
	{
		++count;
		
		slowPtr = slowPtr->next;	
	}
	
	return count;
}

int main()
{
	struct node *head = NULL;	
	
	Push(&head, 10);
	Push(&head, 20);
	Push(&head, 30);
	Push(&head, 40);
	Push(&head, 50);
	Push(&head, 60);
	
	head->next->next->next->next->next->next = head->next; // creating the loop		
		
	printf(" Length of the Loop = %d ", detectAndCountLoop(head));	
}
