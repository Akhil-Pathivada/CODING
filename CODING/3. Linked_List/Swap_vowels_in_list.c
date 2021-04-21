/** 
  * Given the linked list representation of a string,
  * the task is to swap every subsequent pair of vowels in it to produce the resultant linked list.
  *
  * Time Complexity: O(N)
  * Space Complexity: O(1)
  *  */

#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

struct node {

	char data;
	struct node *next;
};

struct node *newNode(char data) {

	struct node *nn = (struct node*)malloc(sizeof(struct node));
	nn->data = data;
	nn->next = NULL;

	return nn;
}

void printList(struct node *curr) {

	while(curr) {

		printf("%c", curr->data);
	       	curr = curr->next;
	}
}

void swapNodesData(struct node **a, struct node **b) {

	char temp = (*a)->data;
	(*a)->data = (*b)->data;
	(*b)->data = temp;
}

bool isVowel(char ch) {
	
	if (ch == 'a' || ch == 'e' ||
	    ch == 'i' || ch == 'o' ||
	    ch == 'u' ||
	    ch == 'A' || ch == 'E' ||
	    ch == 'I' || ch == 'O' ||
	    ch == 'U') {
		return true;
	}
	return false;
}

void swapVowels(struct node *head) {

	struct node *curr = head;
	struct node *first = NULL;

	while(curr) {

		if(isVowel(curr->data) && !first) {

			first = curr;
		}
		else if (isVowel(curr->data) && first){
			
			swapNodesData(&first, &curr);
			first = NULL;
		}
		curr = curr->next;
	}
}

int main() {

	struct node *head = newNode('a');
	head->next = newNode('b');
	head->next->next = newNode('c');
	head->next->next->next = newNode('d');
	head->next->next->next->next = newNode('e');

	printList(head);
	swapVowels(head);
	printList(head);
}
