/*
Program to detect the cycle and get the starting node of the Cycle....

Method-3

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

typedef struct node {

	int data;
	struct node *next;
} Node;

void Push(Node **head, int data) {

	Node *temp = (Node*) malloc(sizeof(Node));
	temp->data = data;
	temp->next = *head;
	*head = temp;
}

Node* detectLoop(Node *head) {

	Node *slow, *fast;
	slow = fast = head;
	
	while(fast && fast->next) {

		slow = slow->next;
		fast = fast->next->next;
		
		if(slow == fast)
			 return slow;
	}
	return NULL;
}

void startNodeOfLoop(Node *slowPtr, Node *fastPtr) {	

	while(slowPtr != fastPtr) {

		slowPtr = slowPtr->next;
		fastPtr = fastPtr->next;
	}
	printf(" Starting node of the Loop = %d ", fastPtr->data);
}

int main() {

	Node *head = NULL;
	
	Push(&head, 10);
	Push(&head, 20);
	Push(&head, 30);
	Push(&head, 40);
	Push(&head, 50);
	
	head->next->next->next->next = head->next; // creating the loop
	
	Node *slowPtr, *fastPtr;			
	
	fastPtr = detectLoop(head);

	if(fastPtr)
		startNodeOfLoop(head, fastPtr);	
	
	else
		printf("Loop not found");		
}
