/*
 Get the left view of a Binary Tree
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

struct node* newNode(int val)
{
	struct node *temp = (struct node*)malloc(sizeof(struct node));
	
	temp->data = val;
	
	temp->left = temp->right = NULL;
	
	return temp;
}

void printLeftView(struct node *root, int *MAX_LEVEL, int level)
{
	if(!root)
		return;
		
	if(*MAX_LEVEL < level)
	{
		printf(" %d,",root->data);
		
		*MAX_LEVEL = level;
	}
	
	// swap the below to lines to get RightView of BT......
	
	printLeftView(root->left, MAX_LEVEL, level+1);
	
	printLeftView(root->right, MAX_LEVEL, level+1);
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
	root->right->right->left = newNode(80);
	root->right->right->right = newNode(90);
	
	int MAX = 0;
	
	printLeftView(root, &MAX, 1);
}
