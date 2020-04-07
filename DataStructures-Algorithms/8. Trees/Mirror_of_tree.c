/*
Program to get the Mirror of the Binary Tree
Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>

struct node 
{
	int data;
	struct node *left, *right;
};

struct node* newNode(int val)
{
	struct node *temp = (struct node*)malloc(sizeof(struct node));
	
	temp->data = val;
	
	temp->left = temp->right = NULL;

	return temp;
}

void Inorder(struct node *t)
{
	if(!t)
		return;
	
	Inorder(t->left);
	
	printf(" %d,",t->data);
	
	Inorder(t->right);
}

void Swap(struct node **left, struct node **right)
{
	struct node *temp = *left;
	
	*left = *right;
	
	*right = temp;
}

void getMirrorTree(struct node *t)
{
	if(!t)
		return;

	getMirrorTree(t->left);

	getMirrorTree(t->right);

	Swap( &t->left, &t->right);
}

void main()
{
	struct node *root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->right->left = newNode(50);
	root->left->right = newNode(60);
	root->right->right = newNode(70);

	getMirrorTree(root);

	Inorder(root);
}
