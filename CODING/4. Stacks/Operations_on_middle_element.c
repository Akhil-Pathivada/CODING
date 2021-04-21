/*
How to implement a stack which will support following operations in O(1) time complexity?
1) push() which adds an element to the top of stack.
2) pop() which removes an element from top of stack.
3) findMiddle() which will return middle element of the stack.
4) deleteMiddle() which will delete the middle element.

Push and pop are standard stack operations.
*/

#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *prev, *next;
};

struct myStack
{
	struct node *head, *mid;
	int count;	
};

struct myStack *createStack()
{
	struct myStack *ms = (struct myStack*)malloc(sizeof(struct myStack));
	
	ms->head = NULL;
	
	ms->count = 0;
	
	return ms;
}

void Push( struct myStack *ms, int newData)
{
	struct node *newnode = (struct node*)malloc(sizeof(struct node));
	
	newnode->data = newData;
	
	newnode->prev = NULL;
	
	newnode->next = ms->head;
	
	ms->count ++;
	
	if(ms->count == 1)
		ms->mid = newnode;
	
	else 
	{
		ms->head->prev = newnode;
		
		if(ms->count & 1)
			ms->mid = ms->mid->prev;
	}
	ms->head = newnode;
}

void deleteMiddle(struct myStack *ms)
{	
	if(ms->head == NULL)
		return;	
	
	struct node *temp = ms->mid->next;
	
	temp->prev = ms->mid->prev;
	
	ms->mid->prev->next = temp;
	
	ms->count --;
	
	free(ms->mid);
	
	if(ms->count == 0)
		ms->head = ms->mid = NULL;
	
	else if(ms->count & 1)
		ms->mid = temp->prev;
	
	else
		ms->mid = temp;	
}

void Pop(struct myStack *ms)
{
	if(ms->head == NULL)
		return;

	ms->head = ms->head->next;
	
	ms->count --;
	
	if(ms->count == 0)
	{
		ms->head = ms->mid = NULL;
		
		return;
	}
	
	if((ms->count & 1) == 0)
		ms->mid = ms->mid->next;
}

int getMiddle(struct myStack *ms)
{
	if(ms->mid == NULL)
		return -1;	
	
	return ms->mid->data;
}

void main()
{
	struct myStack *ms = createStack();
	
	Push(ms,8);
	Push(ms,7);
	Push(ms,6);
	Push(ms,5);
	Push(ms,4);
	Push(ms,3);
	Push(ms,2);
	Push(ms,1);
	
	printf("\n Middle Element = %d ", getMiddle(ms));
	
	deleteMiddle(ms);
	
	printf("\n Middle Element = %d ", getMiddle(ms));
	
	Pop(ms);

	printf("\n Middle Element = %d ", getMiddle(ms));
}
