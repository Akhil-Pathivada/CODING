/*
Density of Binary Tree in One Traversal
Density = size/height

Time Complexity : O(n)
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
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->left=nn->right=NULL;
	return nn;
}

int max(int a,int b)
{
	return a>b?a:b;
}

int getHeightSize(struct node *root,int *size)
{
	if(!root)
		return 0;
	(*size)++;
	if(!root->left && !root->right)
		return 0;
		
	return 1+max(getHeightSize(root->left,size),getHeightSize(root->right,size));
}

int main()
{
	struct node *root=newNode(10);
	root->left=newNode(12);
	root->right=newNode(15);
	root->left->left=newNode(25);
	root->left->right=newNode(30);
	root->right->left=newNode(36);
	root->right->left->left=newNode(56);
	root->right->right=newNode(100);
	int size=0;
	int height=getHeightSize(root,&size);
	printf(" Height of Binary Tree : %f \n",(float)size/(float)height);
}
