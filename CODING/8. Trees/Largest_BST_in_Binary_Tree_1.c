/*
Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST). 
If the complete Binary Tree is BST, then return the size of whole tree.

Time Complexity : O(n^2)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node
{
	int data;
	struct node *left, *right;
};

struct node *newNode(int data)
{
	struct node *nn = (struct node *)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->left = nn->right = NULL;
	
	return nn;
}

int max(int a, int b)
{
	return a > b ? a : b;
}

int size(struct node *root)
{	
	return root ? 1 + size(root->left) + size(root->right) : 0;
}

int minValue(struct node *root)
{
	while(root && root->left)
		root = root->left;
	
	return root->data;		
}

int maxValue(struct node *root)
{
	while(root && root->right)
		root = root->right;
	
	return root->data;		
}

bool isBST(struct node *root)
{
	if(!root)
		return true;
	
	if(root->left && maxValue(root->left) > root->data)
		return false;
	
	if(root->right && minValue(root->right) < root->data)
		return false;
			
	return isBST(root->left) && isBST(root->right);
}

int largestBST(struct node *root)
{
	if(!root)
		return 0;
	
	if(isBST(root))
		return size(root);
	
	return max(largestBST(root->left), largestBST(root->right));
}

void main()
{
	struct node *root = newNode(50); 
  	root->left = newNode(10); 
  	root->right = newNode(60); 
  	root->left->left = newNode(5); 
  	root->left->right = newNode(20); 
  	root->right->left = newNode(55); 
  	root->right->left->left = newNode(45); 
  	root->right->right = newNode(70); 
  	root->right->right->left = newNode(65); 
  	root->right->right->right = newNode(80); 
  	
  	printf(" Size of the largest BST is %d ", largestBST(root)); 
}
