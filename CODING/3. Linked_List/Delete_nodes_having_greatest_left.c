/** 
  * Given a singly linked list, the task is to remove all the nodes which have a greater value on left side.
  *
  * Examples:
  *
  * Input: 12->15->10->11->5->6->2->3
  * Output: Modified Linked List = 12 15
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

void printList(struct node *head) {

	while(head) {

		printf("%d->", head->data);
		head = head->next; 
	}
}

void deleteNodesWithGreatestLeft(struct node *head) {

	struct node *curr, *temp, *maxNode;
        curr = maxNode = head;
	
	while(curr && curr->next) {

		if(curr->next->data >= maxNode->data) {

			curr = curr->next;
			maxNode = curr;
		}
		else {
			curr->next = curr->next->next;
		}
	}
}

int main() {

	struct node *head = newNode(12);
	head->next = newNode(15);
	head->next->next = newNode(10);
	head->next->next->next = newNode(7);
	head->next->next->next->next = newNode(11);
	head->next->next->next->next->next = newNode(5);
	head->next->next->next->next->next->next = newNode(6);
	head->next->next->next->next->next->next->next = newNode(2);
	head->next->next->next->next->next->next->next->next = newNode(3);

	printf("\n Initial List : ");
	printList(head);

	deleteNodesWithGreatestLeft(head);

	printf("\n Result List : ");
	printList(head);
}
