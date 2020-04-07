/*
 Implementing JOSEPHUS Problem for Circular Linked List ....

 Time Complexity :: O(N*M)
 Space Complexity :: O(1)
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
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->next=NULL;
	
	return nn;
}

int getJosephus( struct node *head, int M)
{
	struct node *ptr=head->next;
	
	while(head->next != head)
	{
		for(int count=0; count<M; ++count)
			ptr=ptr->next;
			
		head->next=ptr;
		head=ptr;
	}
	
	return head->data;
}

void printList(struct node *head)
{
	struct node *curr=head;
	
	for( ; curr->next!=head ; curr=curr->next)
		printf(" %d->",curr->data);
}

void main()
{
	struct node *head=newNode(1);
	head->next=newNode(2);
	head->next->next=newNode(3);
	head->next->next->next=newNode(4);
	head->next->next->next->next=newNode(5);
	head->next->next->next->next->next=newNode(6);
	head->next->next->next->next->next->next=newNode(7);
	head->next->next->next->next->next->next->next=newNode(8);
	head->next->next->next->next->next->next->next->next=newNode(9);
	head->next->next->next->next->next->next->next->next->next=head;

	int M=2;
	
	printList(head);
	
	printf("\n Remaining node : %d ",getJosephus(head,M));
}
