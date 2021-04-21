/** Given a linked list, find length of the longest palindrome list that exist in that linked list. */
/** Time Complexity: O(n^2) */
/** Space Complexity: O(1) */
/**  */

#include<stdio.h>
#include<stdlib.h>
#define MAX(a, b) a > b ? a : b

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

int countCommonNodes(struct node *n1, struct node *n2) {
	int count = 0;

	for (; n1 && n2; n1 = n1->next, n2 = n2->next) 
		if(n1->data == n2->data)
			++count;
		else
			break;
	return count;
}

int maxPalindromeLength(struct node *curr) {
	struct node *prev = NULL;
	int result = 0;

	while(curr) {
		struct node *nextNode = curr->next;
		curr->next = prev;

		/** for odd length palindrome  */
		result = MAX(result, countCommonNodes(prev, nextNode) * 2 + 1);

		/** for even length palindrome */
		result = MAX(result, countCommonNodes(curr, nextNode) * 2);

		prev = curr;
		curr = nextNode;
	}
	return result;
}

int main() { 
	struct node *head = newNode(2);
	head->next = newNode(4);
    	head->next->next = newNode(3);
    	head->next->next->next = newNode(3);
    	head->next->next->next->next = newNode(4);
    	head->next->next->next->next->next = newNode(2);
    	head->next->next->next->next->next->next = newNode(15);
	/** printList(head); */
	printf("Max. Palindrome length = %d ", maxPalindromeLength(head));
}
