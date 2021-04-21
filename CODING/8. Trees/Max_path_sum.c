/*
Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

Time Complexity : O(n)
Space Complexity :O(n)

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

int max(int a,int b)
{
	return a>b ? a : b;
}

int findMaxUtil( struct node *root, int *res)
{
	if(!root)
		return 0;

	int ls = findMaxUtil(root->left,res);
	
	int rs = findMaxUtil(root->right,res);
	
	int max_single = max( max(ls,rs) + root->data, root->data);
	
	int max_top = max(ls + rs + root->data, max_single);
	
	*res = max(*res, max_top);	
	
	return max_single;
}

int getMaxSum(struct node *root)
{
	int res = 0;
	
	findMaxUtil(root,&res);
	
	return res;
}

int main()
{
	struct node *root=newNode(10);
	root->left        = newNode(2); 
    	root->right       = newNode(10); 
    	root->left->left  = newNode(20); 
    	root->left->right = newNode(1); 
   	root->right->right = newNode(-25); 
    	root->right->right->left   = newNode(3); 
    	root->right->right->right  = newNode(4);
    	
    	printf("Max. Path Sum = %d ",getMaxSum(root));
}
