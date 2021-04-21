/** Given a singly linked list, delete all occurrences of a given key in it. */
/** (optimized solution) */
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

void printList(struct node *curr) {
	
	while(curr) {
		printf(" %d->", curr->data);
		curr = curr->next;
	}
	printf("\n");
}

void deleteAllOccurences(struct node **head_addr, int key) {
	
	struct node *curr = *head_addr, *prev;

	while (curr && curr->data == key) {

		*head_addr = curr->next;
		free(curr);
		curr = *head_addr;
	}
	while (curr) {

		while (curr && curr->data != key) {
			prev = curr;
			curr = curr->next;
		}

		if (!curr) return;
		
		prev->next = curr->next;
		free(curr);
		curr = prev->next;
	}
}

int main() {

	struct node *head = newNode(1);
	head->next = newNode(2);
	head->next->next = newNode(3);
	head->next->next->next = newNode(1);
	head->next->next->next->next = newNode(4);
	head->next->next->next->next->next = newNode(1);
	
	printList(head);
	
	int key = 1; // Key to delete
	
	deleteAllOccurences(&head, key);
	
	printList(head);
}

