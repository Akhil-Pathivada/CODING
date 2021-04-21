/*
Check if removing an edge can divide a Binary Tree in two halves, of equal size.

Time Complexity : O(n)
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

int checkDividable( struct node *root, bool *res, int n)
{
	if(!root)
		return 0;
	
	int c = 1 + checkDividable(root->left, res, n) + checkDividable(root->right, res, n);
	
	if(c == n-c)
		*res = true;
	
	return c;
}

void main()
{
	 struct node* root = newNode(5); 
    	 root->left = newNode(1); 
    	 root->right = newNode(6); 
   	 root->left->left = newNode(3); 
  	 root->right->left = newNode(7); 
   	 root->right->right = newNode(4); 

	int n = getSize(root);
	
	bool res = false;
	
	checkDividable(root, &res, n);
	
	printf( res ? " Yes " : " No ");
}
