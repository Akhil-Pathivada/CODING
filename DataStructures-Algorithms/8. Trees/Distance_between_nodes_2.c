/*
Given a Binary Search Tree and two keys in it. Find the distance between two nodes with given two keys. 
It may be assumed that both keys exist in BST.

Time Complexity : O(H)
Space Complexity : O(H)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

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

struct node* getLCA(struct node *root, int n1, int n2)
{
	if(!root)
		return 0;

	if(root->data == n1 || root->data == n2)
		return root;

	struct node* leftTree = getLCA(root->left, n1, n2);

	struct node* rightTree = getLCA(root->right, n1, n2);

	if(leftTree && rightTree)
		return root;

	return leftTree ? leftTree : rightTree;
}

int getHeight(struct node *root, int target, int level)
{
	if(!root)
		return -1;
	
	if(root->data == target)
		return level;
		
	int flag = getHeight(root->left, target, level+1);
	
	if(flag != -1)
		return flag;
		
	return getHeight(root->right, target, level+1);
}

int getDistance(struct node *root, int n1, int n2)
{
	struct node* lca = getLCA(root, n1, n2);

	return getHeight(lca, n1, 0) + getHeight(lca, n2, 0) ;
}

void main()
{
	struct node *root = newNode(5);
	root->left = newNode(2);
	root->right = newNode(12);
	root->left->left = newNode(1);
	root->left->right = newNode(3);
	root->right->left = newNode(9);
	root->right->right = newNode(21);
	root->right->right->left = newNode(19);
	root->right->right->right = newNode(25);
	
	printf("Distance = %d ", getDistance(root,9,25));
}
