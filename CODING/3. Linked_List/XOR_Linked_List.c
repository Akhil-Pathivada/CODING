/** 
  * A Memory efficient Doubly Linked List
  * In the XOR linked list, instead of storing actual memory addresses,
  * every node stores the XOR of addresses of previous and next nodes.
  *  */

#include<stdio.h>
#include<stdlib.h>

struct node {

	int data;
	struct node *npx;
};

/* returns XORed value of the node addresses */
struct node* XOR (struct node *a, struct node *b) {

    return (struct node*) ((uintptr_t) (a) ^ (uintptr_t) (b));
}

void insert(struct node **head_addr, int data) {

	struct node *newNode = (struct node*)malloc(sizeof(struct node));
	newNode->data = data;
	newNode->npx = *head_addr;

	if(*head_addr) {

		(*head_addr)->npx = XOR(newNode, (*head_addr)->npx);
	}
	*head_addr = newNode;
}

void printListInForwardDir(struct node *head) {

	struct node *prev = NULL;
       	struct node *curr = head;

	while(curr) {
		
		printf("%d, ", curr->data);
		struct node *next = XOR(prev, curr->npx);
		prev = curr;
		curr = next;
	}
}

int main() {

	struct node *head = NULL;
	insert(&head, 10);
	insert(&head, 20);
	insert(&head, 30);
	insert(&head, 40);

	printListInForwardDir(head);
}
