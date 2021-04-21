/*
Given a binary tree in which each node element contains a number.
Find the maximum possible sum from one leaf node to another.

Time Complexity : O(n)
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

int max(int a,int b)
{
	return a>b ? a : b;
}

int findMaxUtil( struct node *root, int *res)
{
	if(!root)
		return 0;
		
	if(!root->left && !root->right)
		return root->data;

	int ls = findMaxUtil(root->left,res);
	
	int rs = findMaxUtil(root->right,res);
	
	if(root->left && root->right)
	{
		*res = max(*res, ls + rs + root->data);
		
		return max(ls,rs) + root->data;
	}	
	
	return !root->left ? rs + root->data : ls + root->data;
}

int getMaxSum(struct node *root)
{
	int res = 0;
	
	findMaxUtil(root,&res);
	
	return res;
}

int main() 
{ 
	struct node *root = newNode(-15); 
	root->left = newNode(5); 
    	root->right = newNode(6); 
    	root->left->left = newNode(-8); 
    	root->left->right = newNode(1); 
    	root->left->left->left = newNode(2); 
    	root->left->left->right = newNode(6); 
    	root->right->left = newNode(3); 
    	root->right->right = newNode(9); 
    	root->right->right->right= newNode(0); 
    	root->right->right->right->left= newNode(4); 
    	root->right->right->right->right= newNode(-1); 
    	root->right->right->right->right->left= newNode(10); 
    
     	printf("Max pathSum between the leaves = %d ", getMaxSum(root)); 
} 

