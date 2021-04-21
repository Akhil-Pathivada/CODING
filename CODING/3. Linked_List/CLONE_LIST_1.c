/*
Cloning the Linked List

Time Complexity : O(n^2)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *rand;
	struct node *next;
};

void printList(struct node *head)
{
	for( ; head; head=head->next)
		printf("  %d,",head->data);
}

struct node *newNode(int data)
{
	struct node *temp = (struct node *)malloc(sizeof(struct node));
	
	temp->data = data;
	
	temp->next = temp->rand = NULL;
	
	return temp;
}

struct node* alternateSplit( struct node *head, struct node **head1, struct node **head2)
{
	struct node *temp;
	
	*head1 = head;
	
	*head2 = head->next;
	
	while(head)
	{
		temp = head->next;
		
		head->next = temp ? temp->next : temp;
		
		head = temp;
	}
}

void setRandomPointers(struct node *cur)
{
	while(cur)
	{
		cur->next->rand = cur->rand->next;
		
		cur = cur->next->next;
	}
}

struct node *getRandNode( struct node *head, int target)
{
	for( ;head && head->data != target; head=head->next);
	
	return head;
}

struct node* getCloneList(struct node *head)
{
	struct node *temp, *cloneList, *currPtr=head;;
	
	// creating a new list && setting next pointers
	temp = cloneList = newNode(currPtr->data);
	
	currPtr = currPtr->next;
	
	while(currPtr)
	{
		temp->next = newNode(currPtr->data);
		
		temp = temp->next;
		
		currPtr = currPtr->next;
	}
	
	// setting random pointers
	currPtr = head;
	
	temp = cloneList;
	
	while(currPtr)
	{	
		temp->rand = getRandNode(cloneList, currPtr->rand->data);
		
		temp = temp->next;
		
		currPtr = currPtr->next;
	}
	
	return cloneList;
}

void main()
{
	struct node *head = newNode(10);
	head->next = newNode(20);
	head->next->next = newNode(30);
	head->next->next->next = newNode(40);
	head->next->next->next->next = newNode(50);
	head->rand = head->next->next;
	head->next->next->rand = head->next->next->next->next;
	head->next->next->next->next->rand = head->next;
	head->next->next->next->rand = head->next->next;
	head->next->rand = head;
	
	//printList(head);
	
	printList(getCloneList(head));
}
