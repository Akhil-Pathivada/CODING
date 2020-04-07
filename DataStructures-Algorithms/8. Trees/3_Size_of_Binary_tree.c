/*
Program to find the size of the Binary tree
Time Complexity :: O(n)
Size Complexity :: O(n)
*/

#include<stdio.h>
#include<stdlib.h>

struct node 
{
	int data;
	struct node *left,*right;
};

struct node* newNode(int val)
{
	struct node *temp=(struct node*)malloc(sizeof(struct node));
	temp->data=val;
	temp->left=temp->right=NULL;

	return temp;
}

int sizeOfTree(struct node *root)
{
	return root ? 1+sizeOfTree(root->left)+sizeOfTree(root->right) : 0;
}

void main()
{
	struct node *root=newNode(10);
	root->left=newNode(20);
	root->right=newNode(30);
	root->left->left=newNode(40);
	root->right->left=newNode(50);
	root->left->right=newNode(60);

	printf("** Size of the Binary Tree :: %d  **\n",sizeOfTree(root));	
}
