/*
LRU Cache Implementation....

Time Complexity : O(N)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#define size 3

struct node {

	int data;
	struct node *prev, *next;
};

void insertCache(struct node **head, struct node **tail, int data, int *cacheIndex) {

	struct node *nn = (struct node *)malloc(sizeof(struct node));
	nn->data = data;
	nn->prev = NULL;
	nn->next = *head;
	
	if(*head) {
		(*head)->prev = nn;
	}
		
	*head = nn;
	
	if(!*tail) {
		*tail = *head;
	}
	++*cacheIndex;	
}

bool isCacheFree(int rear) {

	return rear != size;
}

void makeAsHead(struct node **head, struct node **tail, struct node *currNode, struct node *prevNode) {

	if(currNode == prevNode) {
		return;
	}
	
	if(currNode == *tail) {
		*tail = prevNode;
	}
	
	prevNode->next = currNode->next;
	
	if(currNode->next) {
		currNode->next->prev = prevNode;
	}
	
	currNode->next = *head;
	currNode->prev = NULL;
	
	(*head)->prev = currNode;
	(*head) = currNode;
}

bool isCacheHit(struct node *head, int page, struct node **curr, struct node **prev) {

	*prev = head;
	
	for( ; head; head = head->next) {

		if(head->data == page) {

			*curr = head;
			return true;
		}
		*prev = head;
	}
	return false;	
}

void replacePage(struct node **head, struct node **tail, int newPage) {

	struct node *temp = *tail;
	temp->data = newPage;

	*tail = (*tail)->prev;
	(*tail)->next = NULL;

	temp->prev = NULL;
	temp->next = *head;
	
	(*head)->prev = temp;
	*head = temp;
}

struct node* replaceLRU(int *ref, int n) {

	struct node *head, *tail, *curr, *prev;
	head = tail = NULL;
	int rear = 0;
		
	for(int i = 0; i < n; ++i) {

		int newPage = ref[i];
		
		if(isCacheFree(rear)) {
			insertCache(&head, &tail, newPage, &rear);
		}
		else if(isCacheHit(head, newPage, &curr, &prev)) {
			makeAsHead(&head, &tail, curr, prev);
		}
		else {
			replacePage(&head, &tail, newPage);
		}
	}
	return head;
}

int main() {

	struct node *cache;
	int ref[] = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3};
	int n = sizeof(ref) / sizeof(*ref);
	
	cache = replaceLRU(ref, n);
	
	printf(" Resultant Cache : ");
	
	for( ; cache; cache = cache->next) {
			printf(" %d,", cache->data); 
	}
}
