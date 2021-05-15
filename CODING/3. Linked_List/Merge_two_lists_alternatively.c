/** 
  * Given two linked lists, insert nodes of second list into first list at alternate positions of first list.
  * For example, if first list is 5->7->17->13->11 and second is 12->10->2->4->6,
  * the first list should become 5->12->7->10->17->2->13->4->11->6 and second list should become empty.
  * The nodes of second list should only be inserted when there are positions available.
  * For example, if the first list is 1->2->3 and second list is 4->5->6->7->8, then first list should become 1->4->2->5->3->6 and second list to 7->8.
  *
  * Use of extra space is not allowed (Not allowed to create additional nodes), i.e., insertion must be done in-place.
  * Expected time complexity is O(n) where n is number of nodes in first list.
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

void mergeListsAltenatively(struct node *head1, struct node **head2) {

	struct node *p_curr = head1;
	struct node *q_curr = *head2;
	struct node *p_next, *q_next;

	while(p_curr && q_curr) {

		p_next = p_curr->next;
		q_next = q_curr->next;
		
		p_curr->next = q_curr;
		q_curr->next = p_next;

		p_curr = p_next;
		q_curr = q_next;

	}
	// update head pointer of second list
	*head2 = q_curr;
}

int main() {

	struct node *head1 = newNode(1);
	head1->next = newNode(2);
	head1->next->next = newNode(3);

	struct node *head2 = newNode(4);
	head2->next = newNode(5);
	head2->next->next = newNode(6);
	head2->next->next->next = newNode(7);
	head2->next->next->next = newNode(8);
	head2->next->next->next->next = newNode(9);

	printf("\n List-1: ");
	printList(head1);
	printf("\n List-2: ");
	printList(head2);

	mergeListsAltenatively(head1, &head2);

	printf("\n List-1: ");
	printList(head1);
	printf("\n List-2: ");
	printList(head2);
}
