/*
Convert a given Binary Tree to Doubly Linked List

The DLL must be the InOrder of Tree....

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>

struct node {

	int data;
	struct node *left,*right;
};

struct node* newNode(int data) {

	struct node* nn = (struct node*)malloc(sizeof(struct node));
	nn->data = data;
	nn->left = nn->right = NULL;

	return nn;
}

void fixPrevPtr(struct node *root) {

	static struct node *prevPtr = NULL;
	
	if(!root)
		return;
		
	fixPrevPtr(root->left);

	root->left = prevPtr;

	prevPtr = root;

	fixPrevPtr(root->right);
}

struct node *fixNextPtr(struct node *root) {

	struct node *nextPtr = NULL;
	
	for( ; root->right; root = root->right);
	
	for( ; root; root = root->left) {

		root->right = nextPtr;
		nextPtr = root;
	}
	return nextPtr;
}

struct node* convertBTtoDLL(struct node* root) {

	fixPrevPtr(root);

	return fixNextPtr(root);
}

void printDLL(struct node *root) {

	struct node *head = convertBTtoDLL(root);
	
	for( ; head->left; head = head->left);
	
	for( ; head; head = head->right)
		printf(" %d,",head->data);
}

int main() {

	struct node* root = newNode(10);
	root->left = newNode(12);
	root->right = newNode(15);
	root->left->left = newNode(25);
	root->left->right = newNode(30);
	root->right->left = newNode(36);
	root->right->right = newNode(47);
	root->right->right->left = newNode(53);
	
	printDLL(root);
}
