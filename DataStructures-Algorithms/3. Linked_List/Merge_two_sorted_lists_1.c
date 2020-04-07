/*
 Merge two sorted Linked Lists......
 Time Complexity :: O(n^2)
 Space Complexity :: O(1)
*/

#include <stdio.h>
#include <stdlib.h>

struct node 
{
	int data;
	struct node *next;
};

struct node *newNode(int data)
{
	struct node *temp = (struct node *)malloc(sizeof(struct node));
	temp->data = data;
	temp->next = NULL;
	return temp;
}

void Swap(struct node *n1,struct node *n2)
{
	int temp=n1->data;
	n1->data=n2->data;
	n2->data=temp;
}

struct node *mergeTwoSortedLists(struct node *head1,struct node *head2)
{
	if(head1->data < head2->data)
		Swap(head1,head2);

	struct node *curr1,*curr2,*prev,*nextPtr;

	for(curr1=head1 ;curr1;curr1=nextPtr)
	{
		nextPtr=curr1->next;

		for(curr2=head2; curr2 && (curr2->data < curr1->data); curr2=curr2->next)
			prev=curr2;

		prev->next=curr1;
		curr1->next=curr2;
	}
	return head2;
}

void printList(struct node *head)
{
	for(; head; head = head->next)
		printf("%d\t", head->data);
}

void main()
{
	struct node *head1 = newNode(10);
	head1->next = newNode(30);
	head1->next->next = newNode(50);
	head1->next->next->next = newNode(70);

	struct node *head2 = newNode(20);
	head2->next = newNode(40);
	head2->next->next = newNode(80);

	printList(mergeTwoSortedLists(head1, head2));
}
