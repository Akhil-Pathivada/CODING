/** 
  * Given an unsorted Linked List of integers. The task is to sort the Linked List into a wave like Line.
  * A Linked List is said to be sorted in Wave Form if the list after sorting is in the form:
  *
  * list[0] >= list[1] <= list[2] >= …..
  * Where list[i] denotes the data at i-th node of the Linked List.
  *
  * Examples:
  *
  * Input : List = 2 -> 4 -> 6 -> 8 -> 10 -> 20
  * Output : 4 -> 2 -> 8 -> 6 -> 20 -> 10
  *
  * Time Complexity: O(N)
  * Space Complexity: O(1)
  *  */

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

int getListSize(struct node *head) {

	int size = 0;
	while(head) {

		++size;
		head = head->next;
	}
	return size;
}

void swapNodes(int *a, int *b) {

	int temp = *a;
	*a = *b;
	*b = temp;
}

void sortInWave(struct node *head) {
	
	int i = 0;
	int n = getListSize(head);

	struct node *prev = NULL;
	struct node *curr = head;

	while(i < n) {

		if(i % 2 == 0) {

			if(i > 0 && (prev->data > curr->data)) {
				swapNodes(&(prev->data), &(curr->data));
			}

			if(i < n - 1 && (curr->data < curr->next->data)) {
				swapNodes(&(curr->data), &(curr->next->data));
			}
		}
		++i;

		prev = curr;
		curr = curr->next;
	}	
}

void printList(struct node *head) {

	while(head) {

		printf("%d->", head->data);
		head = head->next; 
	}
	printf("\n");
}

int main() {

	struct node *head = newNode(10);
	head->next = newNode(90);
	head->next->next = newNode(49);
	head->next->next->next = newNode(2);
	head->next->next->next->next = newNode(1);
	head->next->next->next->next->next = newNode(5);
	head->next->next->next->next->next->next = newNode(23);

	printList(head);

	sortInWave(head);

	printList(head);
}
