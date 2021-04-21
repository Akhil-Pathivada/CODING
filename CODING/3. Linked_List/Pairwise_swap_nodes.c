/*
Pairwise swap elements of a given linked list by changing links.....

Time Complexity : O(n)
Space Complexity : O(n)
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

struct node *pairWiseSwap(struct node *head)
{
	if(!head || !head->next)
		return head;
		
	struct node *temp = head->next->next;
	
	struct node *newHead = head->next;
	
	newHead->next = head;
	
	head->next = pairWiseSwap(temp);
	
	return newHead;
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
	
	head = pairWiseSwap(head);
	
	for( ; head; head=head->next)
		printf(" %d->",head->data);
}
