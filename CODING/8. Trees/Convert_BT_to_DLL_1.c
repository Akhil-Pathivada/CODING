/*
Convert a given Binary Tree to Doubly Linked List

The DLL must be the InOrder of Tree....

Time Complexity : O(n^2)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdlib.h>

struct node {

	int data;
	struct node *left, *right;
};

struct node* newNode(int data) {

	struct node* nn = (struct node*)malloc(sizeof(struct node));
	nn->data = data;
	nn->left = nn->right = NULL;

	return nn;
}

void makeLinks(struct node *Anode,struct node *Bnode) {

	Anode->right = Bnode;
	Bnode->left = Anode;
}

struct node* convertBTtoDLL(struct node* root) {

	if(root->left) {

		struct node* lTree = convertBTtoDLL(root->left);

		for( ; lTree->right; lTree = lTree->right);
		
		makeLinks(lTree, root);
	}
	if(root->right) {

		struct node* rTree = convertBTtoDLL(root->right);

		for( ; rTree->left; rTree = rTree->left);
		
		makeLinks(root, rTree);
	}
	return root;
}

void printDLL(struct node *head) {

	for( ; head->left; head = head->left);
	
	for( ; head; head = head->right)
		printf(" %d,", head->data);
}

int main() {

	struct node* root = newNode(25);
	root->left = newNode(10);
	root->right = newNode(30);
	root->left->left = newNode(5);
	root->left->right = newNode(15);
	root->left->right->left = newNode(12);

	struct node *head = convertBTtoDLL(root);

	printDLL(head);
}
