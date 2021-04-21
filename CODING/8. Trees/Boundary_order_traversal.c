/*
Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root. 

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node
{
	int data;
	struct node *left,*right;
};

struct node* newNode(int val)
{
	struct node* nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
    	
    	nn->left = nn->right = NULL;

    	return nn;
}

void printRightBoundary(struct node *root)
{
	if(!root)
		return;

	if(root->right)
	{
		printRightBoundary(root->right);
		
		printf(" %d",root->data);
	}

	else if(root->left)
	{
		printRightBoundary(root->left);
		
		printf(" %d",root->data);
	}
}

void printLeaves(struct node *root)
{
	if(!root)
		return;

	if(!root->left && !root->right)
		printf(" %d",root->data);

	printLeaves(root->left);

	printLeaves(root->right);
}

void printLeftBoundary(struct node *root)
{
	if(!root)
		return;

	if(root->left)
	{
		printf(" %d",root->data);
		
		printLeftBoundary(root->left);
	}

	else if(root->right)
	{
		printf(" %d",root->data);
		
		printLeftBoundary(root->right);
	}
}

void printBoundaries(struct node *root)
{
	printf(" %d",root->data);

	printLeftBoundary(root->left);

	printLeaves(root);

	printRightBoundary(root->right);
}

void main()
{
    	struct node* root = newNode(20); 
   	root->left = newNode(8); 
    	root->left->left = newNode(4); 
    	root->left->right = newNode(12);
    	root->left->left->left = newNode(1);  
    	root->left->right->left = newNode(10); 
    	root->left->right->right = newNode(14); 
    	root->right = newNode(22); 
    	root->right->right = newNode(25); 
    	root->right->right->left = newNode(29); 
    	root->right->right->right = newNode(30); 

	printBoundaries(root);
}
