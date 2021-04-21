/*
Given a Binary Tree, find size of the Largest Independent Set(LISS) in it. 
A subset of all tree nodes is an independent set if there is no edge between any two nodes of the subset.

(Dynamic Programming)

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include <stdio.h>
#include <stdlib.h>

#define max(a,b) (a>b) ? a: b

struct node 
{
	int data,lis;
	struct node *left, *right;
};

struct node *newNode(int data)
{
	struct node *temp = (struct node *)malloc(sizeof(struct node));
	temp->data = data;
	temp->lis=0;
	temp->left = temp->right = NULL;

	return temp;
}

int LISS( struct node *root)
{
	if(!root)
		return 0;
	
	if(root->lis)
		return root->lis;
	
	if(!root->left && !root->right)
		return (root->lis = 1);
	
	int root_excl = LISS(root->left) + LISS(root->right);
	
	int root_incl = 1;
	
	if(root->left)
		root_incl += LISS(root->left->left) + LISS(root->left->right);
		
	if(root->right)
		root_incl += LISS(root->right->left) + LISS(root->right->right);
		
	return (root->lis = max(root_excl, root_incl));
}

int main()
{
	struct node *root         = newNode(20);
    	root->left                = newNode(8);
    	root->left->left          = newNode(4);
    	root->left->right         = newNode(12);
    	root->left->right->left   = newNode(10);
    	root->left->right->right  = newNode(14);
    	root->right               = newNode(22);
    	root->right->right        = newNode(25);
 
	printf("The size of largest independent set is = %d ", LISS(root));
}
