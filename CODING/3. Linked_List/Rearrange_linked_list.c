/** The problem wants us to reform the linked list structure, such that the elements lesser that a certain value x,  */
/** came before the elements greater or equal to x. This essentially means in this reformed list, */
/** there would be a point in the linked list before which all the elements would be smaller than x and after which  */
/** all the elements would be greater or equal to x. Let's call this point as the JOINT. */
/**  */
/** Time Complexity : O(n) */
/** Space Complexity : O(1) */

#include<stdio.h>
#include<stdlib.h>

struct node {
	int data;
	struct node *next;
};

struct node* newNode(int data) {
	
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	nn->data = data;
	nn->next = NULL;
	return nn;
}

void printList(struct node *head) {
	struct node *curr = head;

	while(curr) {
		printf(" %d->", curr->data);
		curr = curr->next;
	}
	printf("\n");
}

void rearrangeList(struct node **head_addr, int x) {

	struct node *before = (struct node*)malloc(sizeof(struct node));	
	struct node *after = (struct node*)malloc(sizeof(struct node));	
	struct node *before_head = before;
	struct node *after_head = after;
	struct node *curr = *head_addr;

	while (curr) {
		
		if (curr->data < x) {
			before->next = curr;
			before = before->next;
		}
		else {
			after->next = curr;
			after = after->next;
		}
		curr = curr->next;
	}
	after->next = NULL;

	before->next = after_head->next;

	*head_addr = before_head->next;
}

int main() {

	struct node *head = newNode(1);
	head->next = newNode(4);
	head->next->next = newNode(3);
	head->next->next->next = newNode(2);
	head->next->next->next->next = newNode(5);
	head->next->next->next->next->next = newNode(2);

	printList(head);
	
	int x = 3;

	rearrangeList(&head, x);

	printList(head);
}
