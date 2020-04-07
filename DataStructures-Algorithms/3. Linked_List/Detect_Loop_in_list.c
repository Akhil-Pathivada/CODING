/*
Program to detect the loop in the Linked List
Time Complexity :: O(n)
*/

#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
	int data;
	struct node *next;
}Node;

Node *head;

void insertAtBeginning(Node **head, int data)
{
	Node *temp = (Node*) malloc(sizeof(Node));
	
	temp->data = data;
	
	temp->next = (*head);
	
	*head = temp;
}

int detectLoop(Node *head)
{
	Node *slow = head;
	
	Node *fast = head;

	for( ; fast && fast->next ; )
	{
		slow = slow->next;
		
		fast = fast->next->next;

		if(slow == fast)
			 return 1;
	}
	return 0;
}

int main()
{
	insertAtBeginning(&head, 10);
	insertAtBeginning(&head, 20);
	insertAtBeginning(&head, 30);
	insertAtBeginning(&head, 40);
	insertAtBeginning(&head, 50);
	
	head->next->next->next->next = head->next->next; // creating the Loop
			
	int flag = detectLoop(head);

	printf(flag ? "Loop found" : "Loop not found");
}
