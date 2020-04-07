/*
Using Morris PreOrder Traversal, we can traverse the tree without using stack and recursion.

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

void MorrisPreOrder(struct node *curr)
{
	struct node *pre;
	
	while(curr)
	{
		if(!curr->left)
		{
			printf(" %d,",curr->data);
			
			curr = curr->right;
		}
		else
		{
			pre = findPredecessor(curr, curr->left);
			
			if(!pre->right)
			{
				printf(" %d,",curr->data);
				
				pre->right = curr;
				
				curr = curr->left;
			}
			else
			{	
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
	
	MorrisPreOrder(root);
}
