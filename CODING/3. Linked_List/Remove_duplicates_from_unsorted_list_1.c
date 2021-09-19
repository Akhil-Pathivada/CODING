/*
Remove duplicates from an Unsorted Linked List

Time Complexity : O(N ^ 2)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>

struct node {

	int data;
	struct node *next;
};

struct node* newNode(int data){
	
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	nn->data = data;
	nn->next = NULL;

	return nn;
}

void printList(struct node *curr) {

	while(curr) {

		printf(" %d,", curr->data);
		curr = curr->next;
	}
	printf("\n");
}

void removeDuplicates(struct node *head) {
	
	struct node *ptr1, *ptr2;
	ptr1 = head;

	while(ptr1) {

		ptr2 = ptr1->next;

		while (ptr2) {

			if (ptr1->data == ptr2->data){
				ptr1->next = ptr2->next;
			}
			ptr2 = ptr2->next;
		}
		ptr1 = ptr1->next;
	}
}

int main() {
	
	struct node *head = newNode(11);
	head->next = newNode(12);
	head->next->next = newNode(11);
	head->next->next->next = newNode(11);
	head->next->next->next->next = newNode(12);

	printList(head);

	removeDuplicates(head);
	
	printList(head);
}
