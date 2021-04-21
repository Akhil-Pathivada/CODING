/*
Given a binary tree, print all root-to-leaf paths

Time Complexity : O(n)
Space Complexity : O(n)+O(n).......(Array + Recursion)
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

void printPath(int *path,int N)
{
	for(int i=0;i<=N;i++)
		printf(" %d,",path[i]);
	printf("\n");
}
void findLeafPaths(struct node *root,int *path,int pathLen)
{
	if(!root)
		return ;
		
	path[++pathLen]=root->data;
	if(!root->left && !root->right)
		printPath(path,pathLen);
	else
	{
		findLeafPaths(root->left,path,pathLen);
		findLeafPaths(root->right,path,pathLen);
	}
}
int max(int a,int b)
{
	return a>b?a:b;
}
int getHeight(struct node *root)
{
	if(!root)
		return 0;
	if(!root->left && !root->right)
		return 0;
		
	return 1+max(getHeight(root->left),getHeight(root->right));
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
	int N=getHeight(root);
	int path[N];
	findLeafPaths(root,path,-1);
}
