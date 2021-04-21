/*
Program to check the Binary Tree is Sum Tree or not....

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
#include<math.h>

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

int checkSumTree(struct node *root)
{
	if(!root)
		return 0;
		
	if(!root->left && !root->right)
		return root->data;
		
	int leftSum = checkSumTree(root->left);
	
	int rightSum = checkSumTree(root->right);
	
	if(!leftSum || !rightSum)
		return 0;
	
	if(root->data == leftSum + rightSum)
		return 2 * root->data;
	
	return 0;
}

void main()
{
	struct node *root = newNode(50);
	root->left = newNode(15);
	root->right = newNode(10);
	root->left->left = newNode(6);
	//root->left->left->left = newNode(5);
	root->left->right = newNode(9);
	root->right->left = newNode(4);
	root->right->right = newNode(6);
	
	printf(checkSumTree(root) ? "Yes" : "No");
}
