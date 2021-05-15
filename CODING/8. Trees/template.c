
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
