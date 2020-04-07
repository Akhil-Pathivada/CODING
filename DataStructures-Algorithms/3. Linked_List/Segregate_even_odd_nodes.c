/*
Segregate even and odd nodes in a Linked List
	1) Arrange all even node at start.
	2) After even node arrange odd nodes. 

Time Complexity :  O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

struct node 
{
	int data;
	struct node *next;
};

void Push( struct node **head_addr, int data)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->next = *head_addr;
	
	*head_addr = nn;
}

void segregateNodes(struct node **head_addr)
{
	struct node *curr = *head_addr;
	
	struct node *evenList, *oddList, *first_even, *first_odd;
	
	evenList = oddList = first_even = first_odd = NULL;
	
	while(curr)
	{
		int node = curr->data;
		
		if(node%2 == 0)
		{
			if(!evenList)
				first_even = curr;
				
			if(evenList)
				evenList->next = curr;
			
			evenList = curr;
		}
		
		else
		{
			if(!oddList)
				first_odd = curr;
				
			if(oddList)
				oddList->next = curr;
				
			oddList = curr;
		}
		
		curr = curr->next;
	}
	
	evenList->next = first_odd;
	
	oddList->next = NULL;
	
	*head_addr = first_even;
} 

void printList( struct node *curr)
{
	for( ; curr; curr=curr->next)
		printf(" %d,",curr->data);
	
	printf("\n");
}

void main()
{
	struct node *head = NULL;
	
	Push(&head,8);
	Push(&head,7);
	Push(&head,6);
	Push(&head,5);
	Push(&head,4);
	Push(&head,3);
	Push(&head,2);
	Push(&head,1);
	
	printList(head);
	
	segregateNodes(&head);
	
	printList(head);
}
