/*
Given a binary tree, find out if the tree can be folded or not.
A tree can be folded if left and right subtrees of the tree are structure wise Foldable image of each other. An empty tree is considered as foldable. 

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

bool checkFoldable(struct node *root1,struct node *root2)
{
	if(!root1 && !root2)
		return true;

	return root1 && root2 && checkFoldable(root1->left,root2->right) && checkFoldable(root1->right,root2->left);
}

void main()
{
	struct node *root = newNode(1);
	root->left = newNode(2);
	root->left->right = newNode(9);
	root->left->right->left = newNode(12);
	root->right = newNode(3);
	root->right->left = newNode(11);
	root->right->left->right = newNode(13);

	checkFoldable(root->left,root->right)? printf(" Tree is foldable "): printf(" Tree is not foldable ");
}
