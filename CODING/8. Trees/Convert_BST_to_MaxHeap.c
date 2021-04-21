/*
Given a Binary Search Tree which is also a Complete Binary Tree. The problem is to convert a given BST into a Special Max Heap
with the condition that all the values in the left subtree of a node should be less than all the values in the right subtree of the node. 
This condition is applied on all the nodes in the so converted Max Heap.

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

struct node *newNode( int data)
{
	struct node *nn = (struct node *)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->left = nn->right = NULL;
	return nn;
}

void PreOrder( struct node *root)
{
	if(!root)
		return;
		
	printf(" %d,", root->data);
	
	PreOrder(root->left);
	
	PreOrder(root->right);
}

int sizeOfTree(struct node *root)
{	
	if(!root)
		return 0;
		
	return 1 + sizeOfTree(root->left) + sizeOfTree(root->right); 
}

void InOrder( struct node *root, int *arr, int *i)
{
	if(!root)
		return;
		
	InOrder(root->left, arr, i);
	
	arr[++*i] =  root->data;
	
	InOrder(root->right, arr, i);
}

void BSTToMaxHeap( struct node *root, int *arr, int *i)
{
	if(!root)
		return;
		
	
	BSTToMaxHeap(root->left, arr, i);
	
	BSTToMaxHeap(root->right, arr, i);
	
	root->data = arr[++*i];
}

void BSTToMaxHeapUtil(struct node *root)
{
	int N = sizeOfTree(root);
	
	int arr[N];
	
	int index = -1;
	
	InOrder(root, arr, &index);
	
	index = -1;
	
	BSTToMaxHeap(root, arr, &index);
}

int main()
{
	struct node *root = newNode(4);
	root->left = newNode(2);
	root->right = newNode(6);
	root->left->left = newNode(1);
	root->left->right = newNode(3);
	root->right->left = newNode(5);
	root->right->right = newNode(7);
	
	BSTToMaxHeapUtil(root);
	
	PreOrder(root);
}
