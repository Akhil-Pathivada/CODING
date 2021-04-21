/*
Given a Binary Tree where each node has positive and negative values. 
Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree. 
The values of leaf nodes are changed to 0.

Time Complexity : O(N)
Space Complexity : O(N)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

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

int convertToSumTree( struct node *root)
{
	if(!root)
		return 0;
	
	int old_val = root->data;
	
	root->data = convertToSumTree(root->left) + convertToSumTree(root->right);
	
	return root->data + old_val;	
}

void PreOrder( struct node *root)
{
	if(!root)
		return;
		
	printf(" %d,",root->data);
	
	PreOrder(root->left);
	
	PreOrder(root->right);
}

int main()  
{  
   	struct node *root = newNode(10);  
    	root->left = newNode(-2);  
	root->right = newNode(6);  
 	root->left->left = newNode(8);  
    	root->left->right = newNode(-4);  
    	root->right->left = newNode(7);  
    	root->right->right = newNode(5);  
    	
    	convertToSumTree(root);
    	
    	PreOrder(root);
}
