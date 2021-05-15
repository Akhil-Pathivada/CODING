/*
Intersection of two Linked Lists....

Time Complexity :: O(n)
*/

#include<stdio.h>
#include<stdlib.h>

typedef struct node {

	int data;
	struct node *next;
} Node;

void insertAtBegining(Node **head, int val) {

	Node *nn = (Node*)malloc(sizeof(Node));
	nn->data = val;
	nn->next = *head;
	*head = nn;
}

Node* getNode(int diff, Node *h1, Node *h2) {

	for(int count = 0; count < diff; h1 = h1->next) {
		++count;
	}
	
	while(h1 != h2) {

		h1 = h1->next;
		h2 = h2->next;
	}
	return h1;
}

int getCount(Node *head) {

	int count = 0;
	
	for( ; head; head = head->next)
		++count;
	
	return count;
	
}

Node* findIntersectionNode(Node *head1, Node *head2) {

	int len1 = getCount(head1);
	int len2 = getCount(head2);
	int diff = abs(len1 - len2);
	
	return (len1 > len2) ? getNode(diff, head1, head2) : getNode(diff, head2, head1);
}

int main() {

	Node *head1 = NULL, *head2 = NULL;
	
	insertAtBegining(&head1, 10);
	insertAtBegining(&head1, 20);
	insertAtBegining(&head1, 30);
	insertAtBegining(&head1, 40);
	insertAtBegining(&head1, 50);
	insertAtBegining(&head2, 60);
	insertAtBegining(&head2, 70);
	insertAtBegining(&head2, 80);
	
	head2->next->next->next = head1->next->next->next;
	
	Node *temp = findIntersectionNode(head1, head2);
	
	temp ? printf("Intersection Node = %d ", temp->data) : printf("No Intesection found");
}
