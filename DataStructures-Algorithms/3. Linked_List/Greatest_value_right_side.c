/*
Point the arbitrary pointer of every node to the node with greatest value to the right of it in Linked List....
Time Complexity :: O(n)
*/
#include<stdio.h>
#include<stdlib.h>
struct node
{
	int data;
	struct node *arbit,*next;
}*head=NULL;
void Insert(int value)
{
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=value;
	nn->next=nn->arbit=NULL;
	nn->next=head;
	head=nn;
}
void Reverse(struct node **head_addr)
{
	struct node *currPtr=*head_addr,*prevPtr=NULL,*nextPtr;
	while(currPtr)
	{
		nextPtr=currPtr->next;
		currPtr->next=prevPtr;
		prevPtr=currPtr;
		currPtr=nextPtr;
	}
	*head_addr=prevPtr;
}
void setArbitPointers(struct node *head)
{
	Reverse(&head);
	struct node *maxNode=head,*temp;
	for(temp=head->next;temp;temp=temp->next)
	{
		temp->arbit=maxNode;
		maxNode=temp->data > maxNode->data?temp:maxNode;
	}
	Reverse(&head);
}
void Display(struct node *cur)
{
	for( ;cur; printf(" %d->",cur->data),cur=cur->next);
}
void DisplayArbit(struct node *cur)
{
	for( ;cur->next;cur=cur->next)
		printf(" %d->",cur->arbit->data);
}
int main()
{
	int val,ch;
	do
	{
		printf("\n\t1.Insert");
		printf("\n\t2.Display List");
		printf("\n\t3.Set Arbitrary pointers");
		printf("\n\t4.Display Arbitrary pointers");
		printf("\n\nEnter U R Choice :: ");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:
				printf("\nEnter Node to insert :: ");
				scanf("%d",&val);
				Insert(val);
				break;
			case 2:
				Display(head);
				break;
			case 3:
				setArbitPointers(head);
				printf("\n** Arbitrary Pointers set Successfully **\n");
				break;
			case 4:
				DisplayArbit(head);
				break;
		}
	}
	while(ch<5);
}
