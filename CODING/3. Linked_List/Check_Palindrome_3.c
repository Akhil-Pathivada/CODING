/*
 Checking whether a Linked List is PALINDROME or not.....
 Time Complexity :: O(n)
 Space Complexity :: O(1)
*/
#include<stdio.h>
#include<stdlib.h>

typedef struct node {

	int data;
	struct node *next;
} Node;

void Push( Node **head, int val) {

	Node *nn = (Node*)malloc(sizeof(Node));
	nn->data = val;
	nn->next = *head;
	*head = nn;
}

Node* getMiddle(Node *head) {

	Node *slow = head;
	Node *fast = slow->next;

	while(fast && fast->next) {

		slow = slow->next;
		fast = fast->next->next;
	}
	return slow;
}

Node* Reverse(Node *head) {

	Node *prev = NULL;
	Node *curr = head;
	Node *nextPtr;
	
	while(curr) {

		nextPtr = curr->next;
		curr->next = prev;
		prev = curr;
		curr = nextPtr;
	}
	return prev;
}

int checkPalindrome(Node *head) {

	struct node *midPtr = getMiddle(head);
	struct node *secondHalf = Reverse(midPtr->next);
	struct node *curr1 = head;
	struct node *curr2 = secondHalf;	
				
	while(curr1 && curr2) {		

		 if(curr1->data != curr2->data)
		 	return 0;
		 	
		 curr1 = curr1->next;
		 curr2 = curr2->next;		 
	}
	secondHalf = Reverse(secondHalf);
	return 1;
}

int main() {

	Node *head = NULL;	
	
	Push(&head, 1);
	Push(&head, 2);
	Push(&head, 3);
	Push(&head, 4);
	Push(&head, 3);
	Push(&head, 2);
	Push(&head, 1);
				
	printf(checkPalindrome(head) ? "Palindrome" : "Not Palindrome");
}	
