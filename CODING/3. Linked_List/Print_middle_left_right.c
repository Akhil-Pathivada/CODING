/** 
  * Given a Linked List. The task is to traverse the Linked List from middle to left-right order using recursion.
  *
  * If the given Linked List is: 2 -> 5 -> 8 -> 3 -> 7 -> 9 -> 12 -> NULL
  * The Middle to left-right order is : 3, 8, 7, 5, 9, 2, 12
  *
  * Input: 12 -> 25 -> 51 -> 16 -> 9 -> 90 -> 7 -> 2 -> NULL
  * Output: 16, 9, 51, 90, 25, 7, 12, 2.
  *
  * Time Complexity: O(N)
  * Space Complexity: O(N)
  *  */

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

		printf("%d->", curr->data);
		curr = curr->next;
	}
}

int getSize(struct node *head) {

	return head ? 1 + getSize(head->next) : 0;
}

struct node* printMiddleToLeftRightUtil(struct node *head, int middle, int size) {

	if(middle == 1 && size % 2) {
		
		printf("%d, ", head->data);
		
		return head->next;
	}
	else if(middle == 1) {
		
		printf("%d, %d, ", head->data, head->next->data);

		return head->next->next;
	}
	else {

		struct node *ptr = printMiddleToLeftRightUtil(head->next, middle - 1, size);

		printf("%d, ", head->data);
		printf("%d, ", ptr->data);

		return ptr->next;
	}
}

void printMiddleToLeftRight(struct node *head) {

	int size = getSize(head);
	
	int middle;

	// odd
	if(size % 2 != 0) {

		middle = (size + 1) / 2;
	}
	// even
	else {
		middle = size / 2;
	}
	
	printMiddleToLeftRightUtil(head, middle, size);
}

int main() {

	struct node *head = newNode(2);
	head->next = newNode(4);
    	head->next->next = newNode(3);
    	head->next->next->next = newNode(5);
    	head->next->next->next->next = newNode(6);
    	head->next->next->next->next->next = newNode(8);
	head->next->next->next->next->next->next = newNode(9);

	printf("Original List: ");
	printList(head);

	printf("\nResult List: ");
	printMiddleToLeftRight(head);
}
