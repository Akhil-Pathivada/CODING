/** 
  * Given a Binary Tree, the task is to print the nodes that have grandchildren.
  *
  * Time Complexity: O(N)
  * Space Complexity: O(N)
  *  */

#include<stdio.h>
#include<stdlib.h>

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

void printNodesWithGC(struct node *root) {

	if(!root) {
		return;
	}
	if(root->left && root->right) {
		
		if(root->left->left || 
		   root->left->right || 
		   root->right->left || 
		   root->right->right) {

			printf(" %d,", root->data);
		}
	}
	else if(root->left && root->left->left) {

		if(root->left->left || root->left->right) {
			printf(" %d,", root->data);
		}
	}
	else if(root->right) {

		if(root->right->left || root->right->right) {
			printf(" %d,", root->data);
		}
	}
}

int main() {

	struct node *root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->left->right = newNode(50);
	root->right->left = newNode(60);
	root->right->right = newNode(70);	
	
	printNodesWithGC(root);
}
