/*
Given a Perfect Binary Tree, reverse the alternate level nodes of the binary tree. 

Time Complexity : O(N)+O(N)
Space Complexity : O(N)+O(N)
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

void reveseAlternateLevels( struct node *root, int level, int arr[], int *index)
{
	if(!root)
		return;
		
	reveseAlternateLevels(root->left,level+1,arr,index);
		
	if(level & 1)
		root->data = arr[(*index)--];
		
	reveseAlternateLevels(root->right,level+1,arr,index);
}

void fillArray( struct node *root, int level, int arr[], int *index)
{
	if(!root)
		return;
		
	fillArray(root->left,level+1,arr,index);
		
	if(level & 1)
		arr[++*index] = root->data;
	
	fillArray(root->right,level+1,arr,index);
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
	
	int N=getCount(root);
	
	int arr[N],index=-1;
	
	fillArray(root,0,arr,&index);
	
	reveseAlternateLevels(root,0,arr, &index);
	
	PreOrder(root);
}
