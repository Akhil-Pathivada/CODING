/*
Given a Binary Tree, Convert it into its Mirror Tree....

Time complexity : O(N)
Space Complexity : O(N)
*/

#include<stdio.h>
#include<stdlib.h>

struct node {

	int data;
	struct node *left, *right;
};

struct node *newNode(int data) {

	struct node *nn = (struct node*)malloc(sizeof(struct node));
	nn->data = data;
	nn->left = nn->right = NULL;
	
	return nn;
}

void convertToMirrorTree(struct node *root) {

	if(!root) {
		return;
	}
		
	struct node *temp = root->left;
	root->left = root->right;
	root->right = temp;
	
	convertToMirrorTree(root->left);
	convertToMirrorTree(root->right);
}

void preOrder(struct node *root) {
	
	if(!root) {
		return;
	}	
	printf(" %d," ,root->data);
	
	preOrder(root->left);
	preOrder(root->right);
}

int main() {

	struct node *root = newNode(34);
	root->left = newNode(23);
	root->right = newNode(45);
	root->left->left = newNode(12);
	root->left->right = newNode(26);
	root->right->left = newNode(37);
	root->right->right = newNode(40);
	
	preOrder(root);		
	convertToMirrorTree(root);
	preOrder(root);	
}
