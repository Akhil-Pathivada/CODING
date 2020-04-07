/*
Delete nodes which have a greater value on right side

Time Complexity : O(n^2)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

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

void Remove(struct node *n1)
{
	n1->data = n1->next->data;
	
	n1->next = n1->next->next;
}

void Reverse(struct node **head_addr)
{
	struct node *currPtr,*prevPtr,*nextPtr;	
	
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

struct node *deleteNodes(struct node **head_addr)
{
	struct node *curr1, *curr2, *prev;
	
	for(curr1=*head_addr; curr1->next; curr1=curr1->next)
	{
		for(curr2=curr1->next; curr2; curr2=curr2->next)
		{
			if(curr2->data > curr1->data)
			{
				if(curr1 == *head_addr)
					*head_addr = (*head_addr)->next;
				else
					prev->next = curr1->next;
					
				break;
			}
			prev = curr2;
		}
		prev = curr1;
	}
	return *head_addr;
}

void printList(struct node *head)
{
	for( ; head; head=head->next)
		printf(" %d->",head->data);
}

void main()
{
	struct node *head = newNode(15);
	head->next = newNode(24);
	head->next->next = newNode(120);
	head->next->next->next = newNode(81);
	head->next->next->next->next = newNode(10);
	
	printList(head);
	
	printList(deleteNodes(&head));
}
