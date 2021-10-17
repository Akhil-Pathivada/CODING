/*
Check whether the given Binary Tree is BST or not.
Assume, each node in the tree has a distinct key.

Time Complexity : O(n)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<limits.h>

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

bool isBST(struct node *root, struct node **prev) {

	if(!root) {
		return true;
	}
	if(!isBST(root->left, prev)) {
		return false;
	}
	if(*prev && (root->data <= (*prev)->data)) {
		return false;	
	}
	*prev = root;

	return isBST(root->right, prev);	
}

int main() {

	struct node *root = newNode(50); 
  	root->left = newNode(10); 
  	root->right = newNode(60); 
  	root->left->left = newNode(5); 
  	root->left->right = newNode(20); 
  	root->right->left = newNode(55); 
  	root->right->left->left = newNode(45); 
  	root->right->right = newNode(70); 
  	root->right->right->left = newNode(65); 
  	root->right->right->right = newNode(80); 
  	
  	struct node *prev = NULL;
  	printf(isBST(root, &prev) ? "True" : "False"); 
}
