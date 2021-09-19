/*
 Remove duplicate nodes in a sorted linked list
 Time Complexity : O(N)
 Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>

struct node {

	int data;
	struct node *next;
};

struct node* newNode(int val) {

	struct node *nn = (struct node*)malloc(sizeof(struct node));
	nn->data = val;
	nn->next = NULL;

	return nn;
}

void removeDuplicates(struct node *curr) {

	while(curr) {

		if(curr->next && (curr->data == curr->next->data)) {
			curr->next = curr->next->next;
		}
		else {
			curr = curr->next;
		}
	}
}

void printList(struct node *head) {

	for( ; head; head = head->next) {
		printf(" %d->",head->data); 
	}
}

int main() {

	struct node *head=newNode(1);
	head->next=newNode(1);
	head->next->next=newNode(1);
	head->next->next->next=newNode(2);
	head->next->next->next->next=newNode(3);
	head->next->next->next->next->next=newNode(4);
	head->next->next->next->next->next->next=newNode(4);
	head->next->next->next->next->next->next->next=newNode(4);
	head->next->next->next->next->next->next->next->next=newNode(4);

	printf("\n Original List : ");
       	printList(head);

	removeDuplicates(head);

	printf("\n Result List : ");
       	printList(head);
}
