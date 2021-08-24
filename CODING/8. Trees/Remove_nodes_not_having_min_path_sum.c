/** 
  * Given a binary tree, a complete path is defined as a path from root to a leaf.
  * The sum of all nodes on that path is defined as the sum of that path.
  * Given a number K, you have to remove (prune the tree) all nodes which don’t lie in any path with sum>=k.
  *
  * Note: A node can be part of multiple paths. So we have to delete it only in case when all paths from it have sum less than K.
  *
  * https://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/
  *  */
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

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

int main() {

	 struct node* root = NULL;
  	 root = newNode(10);
  	 root->left = newNode(9);
  	 root->right = newNode(8);
  	 root->left->left = newNode(7);
   	 root->left->right = newNode(6);
   	 root->right->left = newNode(5);
   	 root->right->right = newNode(4);
   	 root->left->left->left = newNode(3);
   	 root->left->left->right = newNode(2);
   	 root->left->right->left = newNode(1);

}
