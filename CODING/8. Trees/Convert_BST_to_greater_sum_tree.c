/*
Given a BST, transform it into a greater sum tree where each node 
contains sum of all nodes greater than that node.

https://www.geeksforgeeks.org/transform-bst-sum-tree/
Time Complexity : O(N)
Space Complexity : O(N)
*/


#include<stdio.h>
#include<stdlib.h>

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

void transformBST(struct node *root, int *sum) {

	if(!root) {
		return;
	}

	transformBST(root->right, sum);

	*sum += root->data;
	root->data = *sum - root->data;

	transformBST(root->left, sum);
}

void printInorder(struct node *root) {

	if(!root) {
		return;
	}
	
	printInorder(root->left);
	printf("%d, ", root->data);
	printInorder(root->right);
}

int main() {

	struct node *root = newNode(11);
    	root->left = newNode(2);
    	root->right = newNode(29);
    	root->left->left = newNode(1);
    	root->left->right = newNode(7);
    	root->right->left = newNode(15);
    	root->right->right = newNode(40);
    	root->right->right->left = newNode(35);
  	
 	printInorder(root);

 	int sum = 0;
  	transformBST(root, &sum); 
  	
  	printf("\n");
  	printInorder(root);
}