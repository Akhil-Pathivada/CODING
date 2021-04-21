/*
Checking whether a Linked List is PALINDROME or not.....
Time Complexity : O(n)
Space Complexity : O(n)..... one extra STACK

*/
#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
	int data;
	struct node *next;
}Node;
Node *head=NULL;

int stack[100],top=-1;

void Insert(int val)
{
	Node *nn=(Node*)malloc(sizeof(Node));
	nn->data=val;
	nn->next=head;
	head=nn;
}

void Display(Node *cur)
{
	printf("\n------------------------------------\n");
	for( ;cur; cur=cur->next)
		printf(" %d->",cur->data);
	printf("\n------------------------------------\n");
}

void Push(int val)
{
	stack[++top]=val;
}

int Pop()
{
	return stack[top--];
}

int checkPalindrome(Node *curr)
{
	for( ; curr &&(curr->data==Pop()) ; curr=curr->next);
	return !curr ? 1 : 0;
}

void main()
{
	int val,ch;
	do
	{
		printf("\n\t1.Insert");
		printf("\n\t2.Display");
		printf("\n\t3.Check Palindrome");
		printf("\n Enter U R Choice :: ");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:
				printf("\n Enter Value to insert ::");
				scanf("%d",&val);
				
				Insert(val);
				break;
			case 2:
				Display(head);
				break;
			case 3:
				for(Node *cur=head; cur ; Push(cur->data),cur=cur->next); //Pushing into the Stack
				
				checkPalindrome(head)?printf("\n** PALINDROME **\n"):printf("\n** NOT PALINDROME **\n");
				break;
		}
	}while(ch<4);
}
