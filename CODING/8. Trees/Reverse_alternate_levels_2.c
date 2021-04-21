/*
Given a Perfect Binary Tree, reverse the alternate level nodes of the binary tree. 

Time Complexity : O(N)
Space Complexity : O(N)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node 
{
	int data;
	struct node *left,*right;
};

struct node *newNode(int val)
{
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->left=nn->right=NULL;

	return nn;
}

void Swap( struct node *root1, struct node *root2)
{
	int temp = root1->data;
	root1->data = root2->data;
	root2->data = temp;
}

void reveseAlternateLevels( struct node *root1, struct node *root2, int level)
{
	if(!root1 || !root2)
		return;
		
	if(level & 1)
		Swap(root1,root2);
	
	reveseAlternateLevels(root1->left,root2->right,level+1);
		
	reveseAlternateLevels(root1->right,root2->left,level+1);
}

void PreOrder( struct node *root)
{
	if(!root)
		return;
		
	printf(" %d,",root->data);
	
	PreOrder(root->left);
	PreOrder(root->right);
}

int getCount(struct node *root)
{
	return root ? (1+getCount(root->left)+getCount(root->right)) :0;
}

void main()
{
	struct node *root=newNode(15);
	root->left=newNode(10);
	root->left->left=newNode(5);
	root->left->right=newNode(12);
	root->left->left->left=newNode(4);
	root->left->left->right=newNode(6);
	root->left->right->left=newNode(11);
	root->left->right->right=newNode(13);
	root->right=newNode(20);
	root->right->left=newNode(18);
	root->right->left->left=newNode(17);
	root->right->left->right=newNode(19);
	root->right->right=newNode(30);
	root->right->right->left=newNode(27);
	root->right->right->right=newNode(41);
	
	reveseAlternateLevels(root->left,root->right,1);
	
	PreOrder(root);
}
