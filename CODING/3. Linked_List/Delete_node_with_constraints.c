/*
Given a Singly Linked List, write a function to delete a given node. Your function must follow following constraints:
1) It must accept a pointer to the start node as first parameter and node to be deleted as the second parameter i.e., a pointer to head node is not global.
2) It should not return a pointer to the head node.
3) It should not accept pointer to pointer to head node.

Time Complexity : O(n)
Space Complexity : O(1)

*/
#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *next;
};

struct node *newNode(int data)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->next = NULL;
	
	return nn;
}

void printList( struct node *curr)
{
	for( ;curr; curr=curr->next)
		printf(" %d->",curr->data);
		
	printf("\n");
}

void deleteNode( struct node *head, struct node *target)
{
	if(target==head)
	{
		if(head->next)
		{
			head->data = head->next->data;
			
			target = head->next;
			
			head->next = target->next;
			
			free(target);
			
			return;
		}
	}
	
	struct node *curr = head;
	
	for( ;curr->next && curr->next!=target; curr=curr->next);
	
	if(!curr->next)
		printf(" Node was not found");
	
	else 
		curr->next = curr->next->next;
		
	free(target);
}

void main()
{
	struct node *head = newNode(10);
	head->next = newNode(20);
	head->next->next = newNode(30);
	head->next->next->next = newNode(40);
	head->next->next->next->next = newNode(50);
	
	printList(head);
	
	deleteNode(head,head->next->next);
	
	deleteNode(head,head);
	
	printList(head);
}
