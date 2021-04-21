/*
Given a Binary Search Tree that contains positive integer values greater than 0. 
The task is to check whether the BST contains a dead end or not. Here Dead End means, we are not able to insert any integer element after that node.

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>
#include<limits.h>

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

bool checkDeadEnd(struct node *root, int min, int max)
{
	if(!root)
		return false;
	
	if(min==max)
		return true;
	
	return checkDeadEnd(root->left, min, root->data -1) ||
	       checkDeadEnd(root->right, root->data +1, max);	
}

void main()
{
	struct node *root = newNode(8);
	root->left = newNode(7);
	root->right = newNode(10);
	root->left->left = newNode(2);
	root->right->left = newNode(9);
	root->right->right = newNode(13);
	
	printf(checkDeadEnd(root, 1, INT_MAX) ? "True" : "False");
}
