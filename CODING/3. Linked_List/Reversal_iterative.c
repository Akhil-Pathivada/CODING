/*
Program to Reverse the Linked List
Time Complexity :: O(n)
*/

#include<stdio.h>
#include<stdlib.h>

struct node {

	int data;
	struct node *next;
};

struct node *newNode(int val) {

	struct node *nn = (struct node*)malloc(sizeof(struct node));
	nn->data = val;
	nn->next = NULL;
	return nn;
}

void Display(struct node *cur) {
	
	for( ; cur ; cur = cur->next)
		printf(" %d->", cur->data);
}

void Reverse(struct node **head_addr) {

	struct node *currPtr, *prevPtr, *nextPtr;	
	
	currPtr = *head_addr;
	prevPtr = NULL;
	
	while(currPtr) {

		nextPtr = currPtr->next;
		currPtr->next = prevPtr;
		prevPtr = currPtr;
		currPtr = nextPtr;	
		
	}
	*head_addr = prevPtr;
}

int main() {

	struct node *head = newNode(1);
	head->next = newNode(2);
	head->next->next = newNode(3);
	head->next->next->next = newNode(4);
	head->next->next->next->next = newNode(5);
	head->next->next->next->next->next = newNode(6);
	
	Reverse(&head);
	Display(head);
}
