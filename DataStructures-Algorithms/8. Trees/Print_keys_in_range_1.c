/*
Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. 
Print all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST.
Print all the keys in increasing order.

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

struct node *newNode( int data)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->left = nn->right = NULL;
	
	return nn;
}

void printKeys( struct node *root, int r1, int r2)
{
	if(!root)
		return;
	
	if(root->data > r1)
		printKeys(root->left, r1, r2);
	
	if(root->data >= r1 && root->data <= r2)
		printf(" %d,", root->data);
	
	if(root->data < r2)
		printKeys(root->right, r1, r2);
}

void main()
{
	struct node *root = newNode(20);
	root->left = newNode(8);
	root->right = newNode(22);
	root->left->left = newNode(4);
	root->left->right = newNode(12);
	
	int r1 = 10, r2 = 25;
	
	printKeys(root, r1, r2);
}
