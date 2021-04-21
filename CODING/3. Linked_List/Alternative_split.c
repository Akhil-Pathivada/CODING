/*
Program to split the Alternative nodes in the Linked List.....

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
	int data;
	struct node *next;
}Node;

struct node* newNode(int data)
{
	Node *nn = (Node*)malloc(sizeof(Node));
	
	nn->data = data;
	
	nn->next = NULL;
	
	return nn;
}

void Display(Node *curr)
{
	while(curr)
	{
		printf(" %d->",curr->data);
		
		curr = curr->next;
	}
}

void alternateNodes(Node *head,Node **head1,Node **head2)
{
	Node *temp;
	
	*head1 = head;
	
	*head2 = head->next;
	
	while(head)
	{
		temp = head->next;
		
		head->next = temp ? temp->next : temp;
		
		head = temp;
	}
}

int main()
{
	Node *head, *head1, *head2;
	
	head = newNode(1);
	head->next = newNode(2);
	head->next->next = newNode(3);
	head->next->next->next = newNode(4);
	head->next->next->next->next = newNode(5);
	head->next->next->next->next->next = newNode(6);
		
	alternateNodes(head,&head1,&head2);
				
	Display(head1);
				
	Display(head2);
}
