/*
Check if a binary tree is SubTree of another binary tree 

Time Complexity : O(m*n)
Space Complexity : O(n)
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
	struct node* nn = (struct node*)malloc(sizeof(struct node));
	nn->data = val;
    	nn->left = nn->right = NULL;
    	return nn;
}

bool checkIdentical(struct node *root1,struct node *root2)
{
	if(!root1 && !root2)
		return true;
	if(root1&&root2)
		return (root1->data==root2->data)&& checkIdentical(root1->left,root2->left) && checkIdentical(root1->right,root2->right);
}

bool checkSubTree(struct node *root,struct node *target)
{
	if(!root)
		return false;
	if(root->data==target->data)
		return checkIdentical(root,target);
	return checkSubTree(root->left,target) || checkSubTree(root->right,target);
}

int main() {

	struct node *root1 = newNode(20);
	root1->left=newNode(30);
	root1->left->left=newNode(45);
	root1->left->left->left=newNode(50);
	root1->left->left->left->left=newNode(67);
	root1->left->right=newNode(45);
	root1->left->right->left=newNode(50);
	root1->left->right->left->left=newNode(67);
	root1->left->right->right=newNode(57);
	root1->right=newNode(40);
	root1->right->right=newNode(45);
	root1->right->right->left=newNode(80);
	root1->right->right->right=newNode(100);
	
	struct node *root2=newNode(45);
	root2->left=newNode(50);
	root2->left->left=newNode(67);
	root2->right=newNode(57);
	
	checkSubTree(root1,root2)?printf(" YES \n"):printf(" NO \n");
}
