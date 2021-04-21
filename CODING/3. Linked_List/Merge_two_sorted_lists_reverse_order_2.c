/** 
  * Given two linked lists sorted in increasing order. Merge them such a way that the result list is in decreasing order (reverse order).
  *
  * Input:  a: 5->10->15->40
  *         b: 2->3->20
  * Output: res: 40->20->15->10->5->3->2
  * 
  * This method: O(1) auxiliary space (in-place) and only one traversal of both lists
  *
  * Time Complexity: O(m + n)
  * Space Complexity: O(1)
  *  */

#include <stdio.h>
#include <stdlib.h>

struct node {

	int data;
	struct node *next;
};

struct node *newNode(int data) {

	struct node *temp = (struct node *)malloc(sizeof(struct node));
	temp->data = data;
	temp->next = NULL;

	return temp;
}

void printList(struct node *head) {

	for( ; head; head = head->next) {
		printf(" %d,", head->data);
	}
}

struct node *mergeTwoSortedListsReverse(struct node *head1, struct node *head2) {

	struct node *mergeList = NULL;
	struct node *temp;

	while(head1 && head2) {

		if(head1->data < head2->data) {
			temp = head1->next;
			head1->next = mergeList;
			mergeList = head1;
			head1 = temp;
		}
		else {
			temp = head2->next;
			head2->next = mergeList;
			mergeList = head2;
			head2 = temp;
		}
	}
	while(head1) {
		temp = head1->next;
		head1->next = mergeList;
		mergeList = head1;
		head1 = temp;
	}
	while(head2) {
		temp = head2->next;
		head2->next = mergeList;
		mergeList = head2;
		head2 = temp;
	}
	return mergeList;
}

int main() {

	struct node *head1 = newNode(20);
	head1->next = newNode(40);
	head1->next->next = newNode(60);
	head1->next->next->next = newNode(80);
	head1->next->next->next->next = newNode(120);
	head1->next->next->next->next->next = newNode(150);

	struct node *head2 = newNode(10);
	head2->next = newNode(30);
	head2->next->next = newNode(50);
	head2->next->next->next = newNode(70);

	printList(mergeTwoSortedListsReverse(head1, head2));
}
