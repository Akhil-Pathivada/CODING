/*
Check whether Root to leaf path sum is equal to a given number or not

Time Complexity : O(n)
Space Complexity : O(n).......(Recursion calls)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node
{
	int data;
	struct node *left,*right;
};

struct node* newNode(int val)
{
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->left=nn->right=NULL;
	
	return nn;
}

bool checkPathSum(root,sum)
struct node *root;
int sum;
{
	if(!root)
		return false;
		
	sum -= root->data;
	
	if((sum==0) && !root->left && !root->right)
		return true;
		
	return checkPathSum(root->left,sum)||checkPathSum(root->right,sum);
}

int main()
{
	struct node *root = newNode(10); 
  	root->left = newNode(8); 
  	root->right = newNode(2); 
  	root->left->left = newNode(3); 
  	root->left->right = newNode(5); 
  	root->right->left = newNode(2); 
	
	int sum;
	printf(" Enter Sum : ");
	scanf("%d",&sum);
	
	checkPathSum(root,sum) ? printf(" TRUE ") : printf(" FALSE ");
}
