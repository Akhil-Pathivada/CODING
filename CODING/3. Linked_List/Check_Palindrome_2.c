/*
Checking whether a Linked List is PALINDROME or not.....
Time Complexity : O(n)
Space Complexity : O(n)..... one extra STACK

*/
#include<stdio.h>
#include<stdlib.h>

typedef struct node {

	int data;
	struct node *next;
} Node;

Node *head = NULL;

int stack[100], top = -1;

void Insert(int val) {

	Node *nn = (Node*)malloc(sizeof(Node));
	nn->data = val;
	nn->next = head;
	head = nn;
}

void Display(Node *curr) {

	for( ; curr; curr = curr->next)
		printf(" %d->", curr->data);
}

void Push(int val) {

	stack[++top] = val;
}

int Pop() {

	return stack[top--];
}

int checkPalindrome(Node *curr) {

	for( ; curr && (curr->data == Pop()); curr = curr->next);

	return !curr ? 1 : 0;
}

int main() {

	int val, ch;

	do {
		printf("\n\t1.Insert");
		printf("\n\t2.Display");
		printf("\n\t3.Check Palindrome");
		printf("\n Enter U R Choice :: ");
		scanf("%d",&ch);

		switch(ch) {
			case 1:
				printf("\n Enter Value to insert ::");
				scanf("%d", &val);
				
				Insert(val);
				break;
			case 2:
				Display(head);
				break;
			case 3:
				for(Node *curr = head; curr; Push(curr->data), curr = curr->next); //Pushing into the Stack
				
				printf(checkPalindrome(head) ? "PALINDROME": "NOT PALINDROME");
				break;
		}
	} while(ch < 4);
}
