/*
Run Length Encoding in a Linked List

Time Complexity : O(n)
Space Complexity :O(1)
*/
#include<stdio.h>
#include<stdlib.h>

struct node {

	char ch;
	int count;
	struct node *next;
};

struct node* newNode(char ch) {

	struct node *nn = (struct node*)malloc(sizeof(struct node));
	nn->ch = ch;
	nn->next = NULL;

	return nn;
}

void runLengthEncoding(struct node *curr) {

	for( ; curr; curr = curr->next) {

		int count = 1;
		struct node *temp = curr;

		while(temp->next && (temp->ch == temp->next->ch)) {

			++count;
			temp = temp->next;
		}
		curr->count = count;
		curr->next = temp->next;
	}
}

void printList(struct node *head) {

	for( ; head; head = head->next) {
		printf(" %c,%d->", head->ch, head->count);
	}
	printf("\n");
}

int main() {

	struct node *head = newNode('a');
	head->next = newNode('a');
	head->next->next = newNode('a');
	head->next->next->next = newNode('b');
	head->next->next->next->next = newNode('b');
	head->next->next->next->next->next = newNode('c');
	head->next->next->next->next->next->next = newNode('c');
	head->next->next->next->next->next->next->next = newNode('c');
	head->next->next->next->next->next->next->next->next = newNode('d');

	printList(head);
	runLengthEncoding(head);
	printList(head);
}
