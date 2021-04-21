/** 
  * Given two linked lists sorted in increasing order. Merge them such a way that the result list is in decreasing order (reverse order).
  *
  * Input:  a: 5->10->15->40
  *         b: 2->3->20
  * Output: res: 40->20->15->10->5->3->2
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

struct node *Reverse(struct node *head) {

	struct node *currPtr, *prevPtr, *nextPtr;	
	
	currPtr = head;
	prevPtr = NULL;
	
	while(currPtr) {

		nextPtr = currPtr->next;
		currPtr->next = prevPtr;
		prevPtr = currPtr;
		currPtr = nextPtr;	
		
	}
	return prevPtr;
}

struct node *mergeTwoSortedListsReverse(struct node *head1, struct node *head2) {

	head1 = Reverse(head1);
	head2 = Reverse(head2);

	struct node *mergeList, *res_head;

	if(head1->data > head2->data) {
		res_head = head1;
		head1 = head1->next;
	}
	else {
		res_head = head2;
		head2 = head2->next;
	}
	mergeList = res_head;

	while(head1 && head2) {
		if(head1->data > head2->data) {
			mergeList->next = head1;
			head1 = head1->next;
		}
		else {
			mergeList->next = head2;
			head2 = head2->next;
		}
		mergeList = mergeList->next;	
	}
	mergeList->next = head1 ? head1 : head2;

	return res_head;
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
