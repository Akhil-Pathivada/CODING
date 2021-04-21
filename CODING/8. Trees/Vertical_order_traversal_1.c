/*
Program to get the vertical order of the Binary Tree.....

Time Complexity : O(n*k)....where 'k' is the range of Horizantal distance
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdlib.h>

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

void PreOrder(struct node *root, int *MIN, int *MAX, int count)
{
	if(!root)
		return;
		
	*MIN = (count< *MIN) ? count : *MIN;

	*MAX = (count> *MAX) ? count : *MAX;

	PreOrder(root->left, MIN, MAX, count-1);

	PreOrder(root->right, MIN, MAX, count+1);
}

void printVerticalOrder(struct node *root, int MIN, int count)
{
	if(!root)
		return;
		
	if(count == MIN)
		printf(" %d,",root->data);

	printVerticalOrder(root->left, MIN, count-1);

	printVerticalOrder(root->right, MIN, count+1);
}

void main()
{
	int MIN = 0, MAX = 0;

	struct node *root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->left->left->right = newNode(45);
	root->left->right = newNode(50);
	root->right->left = newNode(60);
	root->right->right = newNode(70);

	PreOrder(root, &MIN, &MAX, 0);

	for( ; MIN<=MAX; MIN++)
		printVerticalOrder(root,MIN,0);
}
