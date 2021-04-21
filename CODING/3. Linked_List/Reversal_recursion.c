/*
Program to Reverse the Linked List (Recursion)

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

struct node *newNode(int val)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->next = NULL;

	return nn;
}

void Display(struct node *cur)
{
	for( ; cur; cur=cur->next)
		 printf(" %d",cur->data);
}

void Reverse(struct node *prev, struct node *cur, struct node **head_addr)
{
	if(cur)
	{
		Reverse(cur, cur->next, head_addr);		
		
		cur->next = prev;
	}
	else
		*head_addr = prev;
}

int main()
{
	struct node *head = newNode(1);
	head->next = newNode(2);
	head->next->next = newNode(3);
	head->next->next->next = newNode(4);
	head->next->next->next->next = newNode(5);
	head->next->next->next->next->next = newNode(6);
	
	Reverse(NULL, head, &head);

	Display(head);
}
