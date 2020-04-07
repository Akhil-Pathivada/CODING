/*
Write a function to connect all the adjacent nodes at the same level in a binary tree. 

Time Complexity : O(n)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>

struct node{
	int data;
	struct node *left, *right, *nextRight;
};

struct node *newNode(int data){
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	nn->data = data;
	nn->left = nn->right = nn->nextRight = NULL;
}

void connectNodesAtSameLevel(struct node *root){
	if(!root)
		return;

	root->nextRight = NULL;

	while(root){
		struct node *temp = root;

			
	}



}

void main(){
	struct node *root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->left->right = newNode(50);
	root->right->left = newNode(60);
	root->right->right = newNode(70);

	connectNodesAtSameLevel(root);
}