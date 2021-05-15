/*
Checking whether a Linked List is PALINDROME or not.....

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

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

Node* newNode(int val) {

	Node *nn = (Node*)malloc(sizeof(Node));
	nn->data = val;
	nn->next = NULL;
	
	return nn;
}

void cloneList(Node *curr) {

	while(curr) {

		Node *temp = newNode(curr->data);
		temp->next = curr->next;
		curr->next = temp;
		curr = temp->next;
	}
}

void alternateSplitNodes( Node *curr, Node **head2_addr) {

	Node *temp;
	*head2_addr = curr->next;
	
	while(curr) {

		temp = curr->next;
		curr->next = temp ? temp->next : temp;
		curr = temp;
	}
}

Node* Reverse(Node **head_addr) {

	Node *prev = NULL;
	Node *curr = *head_addr;
	Node *nextPtr;
	
	while(curr) {

		nextPtr = curr->next;
		curr->next = prev;
		prev = curr;
		curr = nextPtr;
	}
	return prev;
}

bool checkPalindrome(Node *head) {

	Node *copyList = NULL;

	cloneList(head);
	alternateSplitNodes(head, &copyList);
	copyList = Reverse(&copyList);
	
	struct node *curr1 = head;
	struct node *curr2 = copyList;	
				
	while(curr1 && curr2 && (curr1->data == curr2->data)) {		

		 curr1 = curr1->next;
		 curr2 = curr2->next;		 
	}
	return !curr1 && !curr2;
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
