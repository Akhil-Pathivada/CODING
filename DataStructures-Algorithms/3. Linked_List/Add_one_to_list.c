/*
Add 1 to a number represented as linked list.......

Time Complexity :: O(n)
Space Complexity :: O(1)
*/

#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *next;
};

struct node* getNode(int val)
{
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->next=NULL;

	return nn;
}

void Reverse(struct node **head_addr)
{
	struct node *currPtr,*nextPtr,*prevPtr=NULL;

	currPtr=*head_addr;

	while(currPtr)
	{
		nextPtr=currPtr->next;

		currPtr->next=prevPtr;

		prevPtr=currPtr;

		currPtr=nextPtr;
	}

	*head_addr=prevPtr;
}

void printList(struct node *head)
{
	for( ;head;printf("%d->",head->data),head=head->next);

	printf("\n");
}

struct node* addOne(struct node *main_head)
{
	struct node *temp, *head = main_head;

	int carry = 1, sum;

	while(head)
	{
		sum = carry + head->data;

		carry = (sum>=10) ? 1 : 0;

		sum = sum%10;

		head->data = sum;

		temp = head;

		head = head->next;
	}

	if(carry)
		temp->next = getNode(1);

	return main_head;
}

int main()
{
	struct node *head=getNode(9);
	head->next=getNode(9);
	head->next->next=getNode(9);
	head->next->next->next=getNode(9);

	printList(head);

	Reverse(&head);

	head = addOne(head);

	Reverse(&head);

	printList(head);
}
