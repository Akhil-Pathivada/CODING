/*
Check the Linked List contains Even number of elements or not....
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

struct node* newNode(int val)
{
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->next=NULL;

	return nn;
}

int checkEvenOdd(struct node* head)
{
	while(head&&head->next)
		head=head->next->next;

	return head ? 1 : 0;
}

int main()
{
	struct node *head=newNode(1);
	head->next=newNode(2);
	head->next->next=newNode(3);
	head->next->next->next=newNode(4);

	printf(checkEvenOdd(head)? "ODD" : " EVEN");
}
