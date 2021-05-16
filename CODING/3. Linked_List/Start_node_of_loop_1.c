/*
Program to detect the cycle and get the starting node of the Cycle....

Method-1

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node {

	int data;
	struct node *next;
};

void Push(struct node **head, int data) {

	struct node *temp = (struct node*) malloc(sizeof(struct node));
	temp->data = data;
	temp->next = *head;
	*head = temp;
}

void startNodeOfLoop(struct node *head, struct node *loopNode) {

	struct node *ptr1 = head;
	struct node *ptr2;
	
	while(true) {

		ptr2 = loopNode;

		while(ptr2->next != loopNode && ptr2->next != ptr1) {
			ptr2 = ptr2->next;
		}
		if(ptr2->next == ptr1) {
			break;
		}
		ptr1 = ptr1->next;
	}
	printf(" Starting node of Loop = %d ", ptr1->data);
}

struct node *getLoopNode(struct node *head) {

	struct node *slowPtr, *fastPtr;
	slowPtr = fastPtr = head;
	
	while(fastPtr && fastPtr->next) {	

		fastPtr = fastPtr->next->next;
		slowPtr = slowPtr->next;
		
		if(slowPtr == fastPtr)
			return slowPtr;
	}
	return NULL;
}

int main() {

	struct node *head = NULL;
	
	Push(&head, 10);
	Push(&head, 20);
	Push(&head, 30);
	Push(&head, 40);
	Push(&head, 50);
	
	head->next->next->next->next = head->next; // creating the loop
	
	struct node *loopNode = getLoopNode(head);
	
	if(loopNode)
		startNodeOfLoop(head, loopNode);	
}
