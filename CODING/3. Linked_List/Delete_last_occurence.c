/*
Delete last occurrence of an item from linked list

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

struct node {

	int data;
	struct node *next;
};

struct node *newNode(int data) {

	struct node *nn = (struct node*)malloc(sizeof(struct node));
	nn->data = data;
	nn->next = NULL;
	
	return nn;
}

void removeLastOccurence(struct node **head_addr, int key) {

	struct node *head = *head_addr;
	struct node *curr = head;
	struct node *temp, *target = NULL;
	
	for( ; curr; curr = curr->next) {

		if(curr->data == key) {
			target = curr;
		}
	}
	
	if(!target) {
		return; 
	}
	
	if(target == head) {

		*head_addr = (*head_addr)->next;
		return;
	}
	
	if(target->next) {

		temp = target->next;
		target->data = temp->data;
		target->next = temp->next;
		free(temp);
		
		return;
	}
	free(target);
}

int main() {

	struct node *head=newNode(1);
	head->next = newNode(2);
	head->next->next = newNode(4);
	head->next->next->next = newNode(5);
	head->next->next->next->next = newNode(2);
	head->next->next->next->next->next = newNode(7);
	
	int key = 2;
	
	removeLastOccurence(&head,key);
	
	// Printing the list
	for( ; head; head = head->next) {
		printf(" %d->", head->data);
		
	}
}
