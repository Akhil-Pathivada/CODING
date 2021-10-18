/*
Check if a binary tree is subtree of another binary tree 

Time Complexity : O(n)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>
#define MAX 100

struct node {
	char data;
	struct node *left,*right;
};

struct node* newNode(char val) {

	struct node* nn = (struct node*)malloc(sizeof(struct node));
	nn->data = val;
    	nn->left = nn->right = NULL;

    	return nn;
}

void storeInOrder(struct node *root, char Inorder[],int *i) {

	if(!root) {

		Inorder[(*i)++] = '$';
		return;
	}

	storeInOrder(root->left, Inorder, i);
	Inorder[(*i)++] = root->data;
	storeInOrder(root->right, Inorder, i);
}

void storePreOrder(struct node *root, char Preorder[], int *i) {

	if(!root) {

		Preorder[(*i)++] = '$';
		return;
	}

	Preorder[(*i)++] = root->data;
	storePreOrder(root->left, Preorder, i);
	storePreOrder(root->right, Preorder, i);
}

bool checkSubTree(struct node *A,struct node *B) {

	if(!B) {
		return true;
	}
	if(!A) {
		return false;
	}
	
	char InorderA[MAX], InorderB[MAX];
	int m = 0, n = 0;

	storeInOrder(A, InorderA, &n);
	storeInOrder(B, InorderB, &m);
	
	InorderA[n] = '\0';
	InorderB[m] = '\0';
	
	m = 0, n = 0;

	char PreorderA[MAX], PreorderB[MAX];
	storePreOrder(A, PreorderA, &n);
	storePreOrder(B, PreorderB, &m);
	
	PreorderA[n] = '\0';
	PreorderB[m] = '\0';
	
	return (strstr(PreorderA, PreorderB) != NULL) && (strstr(InorderA, InorderB) != NULL);
}

int main() {

	struct node *A = newNode('a');
	A->left = newNode('b');
	A->left->left = newNode('c');
	A->right = newNode('d');
	A->right->right = newNode('e');
	
	struct node *B = newNode('a');
	B->left = newNode('b');
	B->left->left = newNode('c');
	B->right = newNode('d');
	
	printf(checkSubTree(A, B) ? " YES " : " NO ");
}
