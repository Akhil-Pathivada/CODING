/*
Add 1 to a number represented as linked list

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
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->next = NULL;

	return nn;
}

void Reverse(struct node **head_addr)
{
	struct node *currPtr,*nextPtr,*prevPtr;
	
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

void printList(struct node *head)
{
	for( ; head; head=head->next)
		printf("%d->",head->data);

	printf("\n");
}

struct node* addLists(struct node *head1,struct node *head2)
{
	struct node *head3=(struct node*)malloc(sizeof(struct node));

	struct node *result=head3;

	int carry=0,sum;

	while(head1&&head2)
	{
		sum = head1->data + head2->data + carry;

		carry=(sum>=10)?1:0;

		sum%=10;

		head3->next=getNode(sum);

		head1=head1->next;
		head2=head2->next;
		head3=head3->next;
	}

	while(head1||head2)
	{
		if(head1)
		{
			sum = head1->data + carry;
			
			head1 = head1->next;
		}

		else if(head2)
		{
			sum = head2->data + carry;
			
			head2 = head2->next;
		}

		carry=(sum>=10)?1:0;

		sum%=10;

		head3->next = getNode(sum);

		head3 = head3->next;
	}

	if(carry)
		head3->next = getNode(carry);

	return (result->next);
}

int main()
{
	struct node *head1 = getNode(9);
	head1->next=getNode(2);
	head1->next->next=getNode(8);
	head1->next->next->next=getNode(9);
	head1->next->next->next->next=getNode(5);

	struct node *head2 = getNode(5);
	head2->next=getNode(1);
	head2->next->next=getNode(7);
	head2->next->next=getNode(9);
	head2->next->next->next=getNode(4);

	printList(head1);
	printList(head2);

	Reverse(&head1);
	Reverse(&head2);

	struct node *head3 = addLists(head1,head2);

	Reverse(&head3);

	printList(head3);
}
