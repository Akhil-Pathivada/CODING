/*
Given a Binary Search Tree (BST) with duplicates, find the node (the most frequently occurred element) in the given BST. 
If the BST contains two or more such nodes, print any of them.
Note: We cannot use any extra space. (Assume that the implicit stack space incurred due to recursion does not count) 

Time Complexity : O(n)
Space Complexity : O(n)
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
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->left = nn->right = NULL;
	
	return nn;
}

void InOrder( struct node *root, int *maxNode, int *maxCount, int *prev, int count)
{
	if(!root)
		return;	
	
	InOrder(root->left, maxNode, maxCount, prev, count);
	
	int curr = root->data;
	
	if(curr == *prev)
		++count;
	else
		count = 1;
	
	if(count > *maxCount)
	{
		*maxCount = count;
		
		*maxNode = curr;
	}
	
	*prev = curr;
	
	InOrder(root->right, maxNode, maxCount, prev, count);
}

int findMaxNode(struct node *root)
{
	int maxCount, maxNode, prev;
	
	maxCount = maxNode = 0;
	
	prev = root->data;
	
	InOrder(root, &maxNode, &maxCount, &prev, 0);
	
	return maxNode;
}

void main()
{
	struct node* root = newNode(6);
	root->left = newNode(5); 
	root->right = newNode(7); 
        root->left->left = newNode(4); 
        root->left->right = newNode(5); 
        root->right->left = newNode(7); 
        root->right->right = newNode(7); 
        
        printf("Max. Occurence node = %d ", findMaxNode(root));
}
