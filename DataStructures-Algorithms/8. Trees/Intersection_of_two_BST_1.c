/*
Given two Binary Search Trees, find common nodes in them. In other words, find intersection of two BSTs.

Time Complexity : O(m*n)
Space Complexity : O(m*n)
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
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->left = nn->right = NULL;
	
	return nn;
}

bool getIdenticalNode(struct node *root, int target)
{
	if(!root)
		return false;
	
	if(root->data == target)
		return true;
	
	if(root->data > target)
		return getIdenticalNode(root->left, target);
		
	return getIdenticalNode(root->right, target);
}

void printIdenticalNodes( struct node *root, struct node *targetTree)
{
	if(!root)
		return;
	
	int targetNode = root->data;		
			
	if(getIdenticalNode(targetTree, targetNode))
		printf(" %d," ,root->data);
	
	printIdenticalNodes(root->left, targetTree);
	
	printIdenticalNodes(root->right, targetTree);		
}

void main()
{
	struct node *root1 = newNode(5);
	root1->left = newNode(1);
	root1->right = newNode(10);
	root1->left->left = newNode(0);
	root1->left->right = newNode(4);
	root1->right->left = newNode(7);
	root1->right->left->right = newNode(9);
	
	struct node *root2 = newNode(10);
	root2->left = newNode(7);
	root2->right = newNode(20);
	root2->left->left = newNode(4);
	root2->left->right = newNode(9);
	
	printIdenticalNodes(root1, root2);
}
