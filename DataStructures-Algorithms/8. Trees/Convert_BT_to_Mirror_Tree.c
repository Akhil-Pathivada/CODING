/*
Given a Binary Tree, Convert it into its Mirror Tree....

Time complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *left, *right;
};

struct node *newNode(int data)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->left = nn->right = NULL;
	
	return nn;
}

void convertToMirror(struct node *root)
{
	if(!root)
		return;
		
	struct node *temp = root->left;
	
	root->left = root->right;
	
	root->right = temp;
	
	convertToMirror(root->left);
	
	convertToMirror(root->right);
}

void PreOrder(struct node *root)
{
	if(!root)
		return;
		
	printf(" %d," ,root->data);
	
	PreOrder(root->left);
	
	PreOrder(root->right);
}

void main()
{
	struct node *root = newNode(34);
	root->left = newNode(23);
	root->right = newNode(45);
	root->left->left = newNode(12);
	root->left->right = newNode(26);
	root->right->left = newNode(37);
	root->right->right = newNode(40);
	
	PreOrder(root);
		
	convertToMirror(root);
	
	PreOrder(root);	
}
