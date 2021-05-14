
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

void printList(struct node *head) {

	while(head) {

		printf("%d->", head->data);
		head = head->next; 
	}
}
	struct node *head = newNode(9);
	head->next = newNode(9);
	head->next->next = newNode(9);
	head->next->next->next = newNode(9);
