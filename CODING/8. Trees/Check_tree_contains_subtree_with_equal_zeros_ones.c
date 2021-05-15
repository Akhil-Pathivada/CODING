/** 
  * Given a Binary Tree having data at nodes as either 0’s or 1’s. The task is to find out whether there exists a subtree having an equal number of 1’s and 0’s.
  *
  * Time Complexity: O(N)
  * Space Complexity: O(1)
  *  */

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node {

	int data;
	struct node *left,*right;
};

struct node* newNode(int val) {

	struct node *temp = (struct node*)malloc(sizeof(struct node));
	temp->data = val;
	temp->left = temp->right = NULL;

	return temp;
}

// Convert the 0s to -1
void convertZerosToMinusOne(struct node *root) {

	if(!root) {
		return;
	}
	if(root->data == 0) {
		root->data = -1;
	}
	convertZerosToMinusOne(root->left);
	convertZerosToMinusOne(root->right);

	/** root->data = convertZerosToMinusOne(root->left) + convertZerosToMinusOne(root->right); */
}

int convertToSumTree(struct node *root) {

	if(!root) {
		return 0;
	}
	root->data += convertToSumTree(root->left) + convertToSumTree(root->right);

	return root->data;
}

bool checkSubTree(struct node *root, bool isFound) {

	if(!root) {
		return false;
	}
	if(!isFound) {
		isFound = checkSubTree(root->left, isFound);
	}
	if(root->data == 0) {

		isFound = true;
		return isFound;
	}
	if(!isFound) {
		isFound = checkSubTree(root->right, isFound);
	}
	return isFound;
}

int main() {

	// Create the Binary Tree
	struct node* root = newNode(1);
	root->right = newNode(0);
	root->right->right = newNode(1);
	root->right->right->right = newNode(1);
	root->left = newNode(0);
	root->left->left = newNode(1);
	root->left->left->left = newNode(1);
	root->left->right = newNode(0);
	root->left->right->left = newNode(1);
	root->left->right->left->left = newNode(1);
	root->left->right->right = newNode(0);
	root->left->right->right->left = newNode(0);
	root->left->right->right->left->left = newNode(1);

	// Convert all 0s in tree to -1
	convertZerosToMinusOne(root);

	// Convert the tree into a SUM tree
	convertToSumTree(root);

	bool isFound = false;

	printf(checkSubTree(root, isFound) ? "True" : "False");


}
