/*
Given root of binary search tree and K as input, find K-th smallest element in BST.

(Morris InOrder Traversal)
Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

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

struct node *findPredecessor( struct node *curr, struct node *pre)
{
	while(pre->right && pre->right != curr)
		pre = pre->right;
	
	return pre;
}

int KthSmallestElement(struct node *curr, int K)
{
	struct node *pre;
	
	int count = 0;
	
	while(curr)
	{
		if(!curr->left)
		{	
			if(++count == K)
				return curr->data; 
			
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
				if(++count == K)
					return curr->data;
				
				pre->right = NULL;
				
				curr = curr->right;	
			}
		}
	}
}

void main()
{	
	struct node *root = newNode(10);
	root->left = newNode(5);
	root->left->left = newNode(-2);
	root->left->right = newNode(6);
	root->left->right->right = newNode(8);
	root->left->left->right = newNode(2);
	root->left->left->right->left = newNode(-1);
	root->right = newNode(30);
	root->right->right = newNode(40);
	
	int K = 5; 
	
	printf(" %d th smallest element = %d ", K, KthSmallestElement(root,K));
} 
