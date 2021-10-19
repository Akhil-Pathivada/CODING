/*
Iterative implementation to get the Height of Binary Tree

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
#define max(a, b) a > b ? a : b

struct node {

	int data;
	struct node *left, *right;
};

struct node *newNode(int data) {

	struct node *nn = (struct node *)malloc(sizeof(struct node));
	nn->data = data;
	nn->left = nn->right = NULL;
	
	return nn;
}

int maxDepth(struct node *root) {

	if(!root) {
		return 0;
	}
	int lDepth = maxDepth(root->left);
	int rDepth = maxDepth(root->right);

	return max(lDepth, rDepth) + 1;
}

int main() {

  	struct node* root = newNode(1);
    	root->left = newNode(2);
    	root->right = newNode(3);
    	root->left->left = newNode(4);
    	root->left->right = newNode(5);
  	
  	printf("Height of tree is %d", maxDepth(root)); 
}