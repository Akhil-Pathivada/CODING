/*
Program to get the Diameter of the Binary Tree....(RECURSION)

Time Complexity :: O(n)
Space Complexity :: O(n)
*/

#include<stdio.h>
#include<stdlib.h>

struct node 
{
	int data;
	struct node *left,*right;
}*root;

struct node* newNode(int val)
{
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->left=nn->right=NULL;

	return nn;
}

int max(int a,int b)
{
	return a>b ? a : b;
}

int getDiameter( struct node *root, int *height)
{
	int leftDiameter = 0, rightDiameter = 0;

	int leftTreeHeight = 0,rightTreeHeight = 0;

	if(!root)
	{
		*height = 0;

		return 0;
	}

	leftDiameter = getDiameter(root->left, &leftTreeHeight);

	rightDiameter = getDiameter(root->right, &rightTreeHeight);

	*height = 1 + max(leftTreeHeight, rightTreeHeight);

	return max(leftTreeHeight+rightTreeHeight+1, max(leftDiameter,rightDiameter));
}

void main()
{
	int diameter,height;
	root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->left->right = newNode(50);
	root->right->left = newNode(60);
	root->right->right = newNode(70);

	printf(" Diameter of the Tree : %d \n",getDiameter(root,&height));
}
