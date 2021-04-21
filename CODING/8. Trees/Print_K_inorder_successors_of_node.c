/** 
  * Given a Binary Tree and two numbers P and K,
  * the task is to print the K Inorder Successor of the given number P from the Binary tree in constant space.
  *
  * Time Complexity: O(N)
  * Space Complexity: O(1)
  *  */

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

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

struct node *findPredecessor( struct node *curr, struct node *pre) {

	while(pre->right && pre->right != curr)
		pre = pre->right;
	
	return pre;
}

// Print the inorder successors using Morris Inorder Traversal
void morrisInorderTraversal(struct node *curr, int p, int k) {

	struct node* pre;
	bool flag = false;
	
	while(curr) {

		if(!curr->left) {

			if(flag){

				printf(" %d,", curr->data);
				--k;
			}
			if(curr->data == p) {
				
				flag = true;
			}
			if(k == 0) {

				flag = false;
			}
			curr = curr->right;
		}
		else {

			pre = findPredecessor(curr, curr->left);

			if(!pre->right) {

				pre->right = curr;
				curr = curr->left;
			}
			else {

				if(flag){

					printf(" %d,", curr->data);
					--k;
				}
				if(curr->data == p) {

					flag = true;
				}
				if(k == 0) {

					flag = false;
				}

				pre->right = NULL;
				curr = curr->right;
			}
		}
	}
}

int main() {

	struct node *root = newNode(1);
	root->left = newNode(12);
	root->left->left = newNode(3);
	root->right = newNode(11);
	root->right->left = newNode(4);
	root->right->left->right = newNode(15);
	root->right->right = newNode(13);
	root->right->right->left = newNode(9);

	int p = 12;
	int k = 4;

	morrisInorderTraversal(root, p , k);
}
