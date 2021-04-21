/*
Find the distance between two keys in a binary tree, no parent pointers are given.
Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.

Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)

Time Complexity : O(n)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node
{
	int data;
	struct node *left, *right;
};

struct node* newNode(int val)
{
	struct node *temp = (struct node*)malloc(sizeof(struct node));
	
	temp->data = val;
	
	temp->left = temp->right = NULL;

	return temp;
}

int getLCA(struct node *root, int n1, int n2)
{
	if(!root)
		return 0;

	if(root->data == n1 || root->data == n2)
		return root->data;

	int leftTree = getLCA(root->left, n1, n2);

	int rightTree = getLCA(root->right, n1, n2);

	if(leftTree && rightTree)
		return root->data;

	return leftTree ? leftTree : rightTree;
}

int findDistance(struct node *root, int target, int level)
{
	if(!root)
		return -1;
	
	if(root->data == target)
		return level;
		
	int flag = findDistance(root->left, target, level+1);
	
	if(flag != -1)
		return flag;
		
	return findDistance(root->right, target, level+1);
}

int getDistance(struct node *root, int n1, int n2)
{
	int lca = getLCA(root, n1, n2);
	
	int d1, d2, d3, d4;
	
	d1 = findDistance(root, n1, 0);
	
	d2 = findDistance(root, n2, 0);
	
	d3 = findDistance(root, lca, 0);
	
	printf(" %d, %d, %d,", d1,d2,lca);
	
	d4 = d1 + d2 - (2 * d3);
	
	return d4;
}

void main()
{
	struct node *root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->left->right = newNode(50);
	root->right->left = newNode(60);
	root->right->right = newNode(70);
	
	printf("Distance = %d ", getDistance(root,50,70));
}
