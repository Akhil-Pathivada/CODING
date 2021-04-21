/*
Given a binary tree, find out if the tree can be folded or not.
A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other. An empty tree is considered as foldable. 

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node {

	int data;
	struct node *left, *right;
};

struct node* newNode(int val) {

	struct node* nn = (struct node*)malloc(sizeof(struct node));
	nn->data = val;
    	nn->left = nn->right = NULL;

    	return nn;
}

void Swap(struct node **left, struct node **right) {

	struct node *temp = *left;
	*left = *right;
	*right = temp;
}

void convertToMirror(struct node *root) {

	if(!root)
		return;

	Swap(&root->left, &root->right);

	convertToMirror(root->left);
	convertToMirror(root->right);
}

bool checkIdentical(struct node *root1,struct node *root2) {

	if(!root1 && !root2)
		return true;

	return root1 && root2 && checkIdentical(root1->left, root2->left) && checkIdentical(root1->right, root2->right);
}

void main() {

	struct node *root = newNode(1);
	root->left = newNode(2);
	root->left->right = newNode(9);
	root->left->right->left = newNode(12);
	root->right = newNode(3);
	root->right->left = newNode(11);
	root->right->left->right = newNode(13);

	convertToMirror(root->right);

	checkIdentical(root->left, root->right) ? printf(" Tree is foldable") : printf(" Tree is not foldable");
}
