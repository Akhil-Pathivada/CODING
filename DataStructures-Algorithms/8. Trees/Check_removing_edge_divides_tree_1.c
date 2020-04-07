/*
Check if removing an edge can divide a Binary Tree in two halves, of equal size.

Time Complexity : O(n ^ 2)
Space Complexity  : O(n)
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
	struct node *temp = (struct node*)malloc(sizeof(struct node));
	
	temp->data = val;
	
	temp->left = temp->right = NULL;

	return temp;
}

int getSize(struct node *root)
{
	if(!root)
		return 0;
	
	return 1 + getSize(root->left) + getSize(root->right);	
}

bool checkDividable( struct node *root, int N)
{
	if(!root)
		return false;
	
	if(getSize(root) == N - getSize(root))
		return true;
	
	return checkDividable(root->left, N) || 
	       checkDividable(root->right, N);
}

void main()
{
	 struct node* root = newNode(5); 
    	 root->left = newNode(1); 
    	 root->right = newNode(6); 
   	 root->left->left = newNode(3); 
  	 root->right->left = newNode(7); 
   	 root->right->right = newNode(4); 	

	int N = getSize(root);

	printf(checkDividable(root, N) ? " Yes " : " No ");
}
