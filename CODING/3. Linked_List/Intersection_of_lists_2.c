/*
 Intersection of two Linked Lists....
 Time Complexity :: O(n)
 here, we are creating the loop by ourselves
 Problem compresses to get the start node of the Loop
*/
#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
	int data;
	struct node *next;
}Node;

void insertAtBegining(Node **head,int val)
{
	Node *nn = (Node*)malloc(sizeof(Node));
	
	nn->data = val;
	
	nn->next = (*head);
	
	*head = nn;
}

Node* detectLoop(Node *head)
{
	Node *slow,*fast;
	
	for(slow=head,fast=head ; fast&&fast->next ; )
	{
		slow=slow->next;
		
		fast=fast->next->next;
		
		if(slow==fast)
			 return slow;
	}
	return NULL;
}

void main()
{
	Node *head1=NULL,*head2=NULL;
	
	insertAtBegining(&head1,10);
	insertAtBegining(&head1,20);
	insertAtBegining(&head1,30);
	insertAtBegining(&head1,40);
	insertAtBegining(&head1,50);
	insertAtBegining(&head2,60);
	insertAtBegining(&head2,70);
	insertAtBegining(&head2,80);
	
	head2->next->next->next = head1->next->next->next;
	
	head1->next->next->next->next->next = head1;

	Node *slowPtr,*fastPtr;	
			
	fastPtr = detectLoop(head2);
	
	printf(fastPtr ? "*Loop found* " : "*Loop not found* ");

	if(fastPtr)
	{
		slowPtr=head2;
		
		while(slowPtr!=fastPtr)
		{
			slowPtr=slowPtr->next;
			
			fastPtr=fastPtr->next;
		}
		
		printf("\n** Intersection Point :: %d **", fastPtr->data);
	}
}
