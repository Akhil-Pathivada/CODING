/*
A tree is Continuous tree if in each root to leaf path, absolute difference between keys of two adjacent is 1. 
We are given a binary tree, we need to check if tree is continuous or not.

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<math.h>

struct node {

	int data;
	struct node *left, *right;
};

struct node *newNode(int val) {

	struct node *nn = (struct node*)malloc(sizeof(struct node));
	nn->data = val;
	nn->left = nn->right = NULL;
	
	return nn;
}

bool checkContinuous(struct node *root) {

	if(!root) {
		return true;
	}
	
	if(!root->left && !root->right) {
		return true;
	}
	
	int v1 = root->data;
	
	if(root->left) {

		int v2 = root->left->data;
		
		if(abs(v1 - v2) != 1) {
			return false;
		}
	}
	if(root->right) {

		int v2 = root->right->data;
		
		if(abs(v1 - v2) != 1) {
			return false;
		}
	}
	return checkContinuous(root->left) && checkContinuous(root->right);
}

int main() {

	struct node *root = newNode(3);
	root->left = newNode(2);
	root->right = newNode(4);
	root->left->left = newNode(1);
	root->left->right = newNode(3);
	root->right->left = newNode(5);
	root->right->right = newNode(5);
	
	printf(checkContinuous(root) ? " YES " : " NO ");
}
