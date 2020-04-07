/*Subtract two numbers represented as linked list

Time Complexity :: O(max(m,n))
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
	struct node *currPtr,*nextPtr,*prevPtr;

	currPtr=*head_addr;
	prevPtr=NULL;

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

struct node* subtractLists(struct node *head1,struct node *head2)
{
	struct node *head3=(struct node*)malloc(sizeof(struct node));

	struct node *result=head3;

	int diff;

	while(head1&&head2)
	{
		if(head1->data < head2->data)
		{
			head1->next->data = head1->next->data-1;
			head1->data += 10;
		}

		diff=head1->data-head2->data;

		head3->next=getNode(diff);

		head1=head1->next;
		head2=head2->next;
		head3=head3->next;
	}

	for( ;head1; head1=head1->next)
		head3->next=getNode(head1->data);

	for( ;head2; head2=head2->next)
		head3->next=getNode(head2->data);
	
	return (result->next);
}

int main()
{
	struct node *head1=getNode(1);
	head1->next=getNode(8);
	head1->next->next=getNode(7);
	head1->next->next->next=getNode(5);
	head1->next->next->next->next=getNode(3);

	struct node *head2=getNode(9);
	head2->next=getNode(9);
	head2->next->next=getNode(9);
	head2->next->next->next=getNode(9);
	//head2->next->next->next->next=getNode(9);

	printList(head1);
	printList(head2);

	Reverse(&head1);
	Reverse(&head2);

	struct node *head3 = subtractLists(head1,head2);

	Reverse(&head3);

	printList(head3);
}
