/*
Given a linked list and two integers M and N. Traverse the linked list such that you retain M nodes then 
delete next N nodes, continue the same till end of the linked list. It is assumed that M cannot be 0.

Time Complexity : O(n)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *next;
};

void skipMremoveN( struct node *curr, int m, int n)
{
	while(curr)
	{
		for(int i=1; i<m && curr ; ++i)
			curr = curr->next;
		
		if(!curr)
			return;
		
		struct node *temp = curr->next;
		
		for(int i=0; i<n && temp; ++i)
		{
			struct node *t = temp;
			
			temp = temp->next;
			
			free(t);
		}
			
		curr->next = temp;
		
		curr = temp;
	}
}

void Push( struct node **head, int data)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->next = *head;
	
	*head = nn;
}

void printList(struct node *curr)
{
	for( ; curr; curr=curr->next)
		printf("%d ", curr->data);
}

void main()
{
	struct node *head = NULL;
	
	Push(&head, 10);
	Push(&head, 9);
	Push(&head, 8);
	Push(&head, 7);
	Push(&head, 6);
	Push(&head, 5);
	Push(&head, 4);
	Push(&head, 3);
	Push(&head, 2);
	Push(&head, 1);

	int m = 2, n = 3;
	
	skipMremoveN(head, m, n);
	
	printList(head);
}
