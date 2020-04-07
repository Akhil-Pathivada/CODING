/*
Check whether the given Binary Tree is BST or not.
Assume, each node in the tree has a distinct key.

(Morris InOrder Traversal)
Time Complexity : O(n)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<limits.h>

struct node
{
	int data;
	struct node *left, *right;
};

struct node *newNode(int data)
{
	struct node *nn = (struct node *)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->left = nn->right = NULL;
	
	return nn;
}

int max(int a, int b)
{
	return a>b ? a : b;
}

int size(struct node *root)
{	
	return root ? 1 + size(root->left) + size(root->right) : 0;
}

int minValue(struct node *root)
{
	while(root && root->left)
		root = root->left;
	
	return root->data;		
}

int maxValue(struct node *root)
{
	while(root && root->right)
		root = root->right;
	
	return root->data;		
}

struct node *findPredecessor( struct node *curr, struct node *pre)
{
	while(pre->right && pre->right != curr)
		pre = pre->right;
	
	return pre;
}

bool isBST(struct node *curr)
{
	struct node *pre;
		
	int prev = INT_MIN;
	
	while(curr)
	{
		if(!curr->left)
		{
			if(curr->data > prev)
				prev = curr->data;
			else
				return false;
				
			curr = curr->right;
		}
		else
		{
			pre = findPredecessor(curr, curr->left);
			
			if(!pre->right)
			{
				pre->right = curr;
				
				curr = curr->left;
			}
			else
			{
				if(curr->data > prev)
					prev = curr->data;
				else
					return false;
				
				pre->right = NULL;
				
				curr = curr->right;	
			}
		}
	}
	
	return true;
}

void main()
{
	struct node *root = newNode(50); 
  	root->left = newNode(10); 
  	root->right = newNode(60); 
  	root->left->left = newNode(5); 
  	root->left->right = newNode(20); 
  	root->right->left = newNode(55); 
  	root->right->left->left = newNode(45); 
  	root->right->right = newNode(70); 
  	root->right->right->left = newNode(65); 
  	root->right->right->right = newNode(80); 
  	
  	printf(isBST(root) ? "True" : "False"); 
}
