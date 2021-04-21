/*
Given two Binary Search Trees, find common nodes in them. In other words, find intersection of two BSTs.

Time Complexity : O(m+n)
Space Complexity : O(m+n)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

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

int sizeOfTree( struct node *root)
{
	return root ? 1 + sizeOfTree(root->left) + sizeOfTree(root->right) : 0;  
}

void placeInOrder( struct node *root, int *arr, int *index)
{
	if(!root)
		return;
	
	placeInOrder(root->left, arr, index);
	
	arr[++*index] = root->data;
	
	placeInOrder(root->right, arr, index);
}

int intersectionArrays( int *arr1, int *arr2, int m, int n)
{
	int i = 0, j = 0;

	while(i < m && j < n)
	{	
		if(arr1[i] < arr2[j])
			++i;
		
		else if(arr1[i] > arr2[j])
			++j;
		
		else
		{
			printf(" %d," ,arr1[i++]);
			
			++j;
		}
	}
}

void printIdenticalNodes( struct node *tree1, struct node *tree2)
{
	int m, n, index;
	
	m = sizeOfTree(tree1);
	
	n = sizeOfTree(tree2);
	
	int arr1[m], arr2[n];
	
	index = -1;
	
	placeInOrder(tree1, arr1, &index);
	
	index = -1;
	
	placeInOrder(tree2, arr2, &index);
	
	intersectionArrays(arr1, arr2, m, n);		
}

void main()
{
	struct node *root1 = newNode(5);
	root1->left = newNode(1);
	root1->right = newNode(10);
	root1->left->left = newNode(0);
	root1->left->right = newNode(4);
	root1->right->left = newNode(7);
	root1->right->left->right = newNode(9);

	
	struct node *root2 = newNode(10);
	root2->left = newNode(7);
	root2->right = newNode(20);
	root2->left->left = newNode(4);
	root2->left->right = newNode(9);
	
	printIdenticalNodes(root1, root2);
}
