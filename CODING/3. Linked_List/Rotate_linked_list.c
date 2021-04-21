/*
 Program to rotate the Linked List by 'd' elements
 Time Complexity :: O(n)
 Space Complexity :: O(1)
*/
#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
	int data;
	struct node *next;
}Node;

Node *head=NULL,*head2=NULL;

struct node *newNode(int val)
{
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->next=NULL;

	return nn;
}

void Insert(int val)
{
	Node *nn=(Node*)malloc(sizeof(Node));
	nn->data=val;
	nn->next=head;
	head=nn;
}

void Display(Node *cur)
{
	for( ;cur; cur=cur->next)
		printf(" %d->",cur->data);

	printf("\n");
}

void rotateList(Node **main_head,int d)
{
	Node *temp_head,*lastNode,*temp_last;
	temp_last=*main_head;

	for(int i=1;i<d;i++) // O(d)
		temp_last=temp_last->next;

	temp_head=temp_last->next;
	for(lastNode=temp_head; lastNode->next ; lastNode=lastNode->next); // O(n-d)

	lastNode->next=*main_head;
	temp_last->next=NULL;
	*main_head=temp_head;
}

int main()
{
	struct node *head=newNode(1);
	head->next=newNode(2);
	head->next->next=newNode(3);
	head->next->next->next=newNode(4);
	head->next->next->next->next=newNode(5);
	head->next->next->next->next->next=newNode(6);
		
	Display(head);
	int d=2;
	rotateList(&head,d);
	Display(head);
} 


