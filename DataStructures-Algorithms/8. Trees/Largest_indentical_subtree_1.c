/*
Given a binary tree, find the largest subtree having identical left and right subtree.

Time Complexity : O(n^2)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *left,*right;
};

struct node *newNode(int val)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->left = nn->right = NULL;

	return nn;
}

int max( int a, int b)
{
	return a>b ? a : b;
}

int checkIdentical( struct node *root1, struct node *root2)
{
	if(!root1 || !root2)
		return 1;
		
	return (root1->data == root2->data) && checkIdentical(root1->left,root2->left) && checkIdentical(root1->right,root2->right);
}

int sizeOfTree(struct node *root)
{
	return root ? 1 + sizeOfTree(root->left) + sizeOfTree(root->right) : 0;
}

void maxSubTree( struct node *root, struct node **maxNode, int *maxSize)
{
	if(!root)
		return ;
	
	int size=0,flag=0;
	
	flag = checkIdentical(root->left,root->right);
	
	if(flag)
		size = sizeOfTree(root);
	
	if(size > *maxSize)
	{
		*maxSize = size;
		
		*maxNode = root;
	}
	
	maxSubTree(root->left,maxNode,maxSize);
	
	maxSubTree(root->right,maxNode,maxSize);
}

void main()
{
	struct node *root = newNode(50);
	root->left = newNode(10);
	root->right = newNode(60);
	root->left->left = newNode(5);
	root->left->right = newNode(20);
	root->right->left = newNode(70);
	root->right->right = newNode(70);
	root->right->left->left = newNode(65);
	root->right->left->right = newNode(80);
	root->right->right->left = newNode(65);
	root->right->right->right = newNode(80);
	
	int maxSize = 0;
	
	struct node *maxNode = NULL;
	
	maxSubTree(root,&maxNode,&maxSize);
	
	printf(" Max. Sub tree found at : %d ", maxNode->data);
}
