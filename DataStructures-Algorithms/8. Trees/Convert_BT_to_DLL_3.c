/*
Convert a given Binary Tree to Doubly Linked List

The DLL must be the InOrder of Tree....

Time Complexity : O(n)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *left,*right;
};

struct node* newNode(int data)
{
	struct node* nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->left = nn->right = NULL;

	return nn;
}

void convertBTtoDLL( struct node* root, struct node **head)
{
	static struct node *prev = NULL;
	
	if(!root)
		return;
	
	convertBTtoDLL(root->left, head);
	
	if(!prev)
		*head = root;
	else
	{
		root->left = prev;
		
		prev->right = root;
	}
	prev = root;
	
	convertBTtoDLL(root->right, head);
}

void printDLL(struct node *root)
{
	struct node *head;
	
	convertBTtoDLL(root, &head);
	
	for( ; head->left; head=head->left);
	
	for( ;head; head=head->right)
		printf("%d ", head->data);
}

void main()
{
	struct node* root=newNode(10);
	root->left = newNode(12);
	root->right = newNode(15);
	root->left->left = newNode(25);
	root->left->right = newNode(30);
	root->right->left = newNode(36);
	root->right->right = newNode(47);
	root->right->right->left = newNode(53);
	
	printDLL(root);
}