/*
Sum of the Binary Tree
Time Complexity :: O(n)
Space Complexity :: O(logn)....recursive calls

*/
#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
	int data;
	struct node *left,*right;
}Node;

Node *root;

Node* newNode(int val)
{
	Node *nn=(Node*)malloc(sizeof(Node));
	nn->data=val;
	nn->left=nn->right=NULL;

	return nn;
}

int sumBT(struct node *root)
{
	if(root)
		return (root->data+sumBT(root->left)+sumBT(root->right));
	return 0;
}

void main()
{
    Node* root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->left->right = newNode(5);
    root->right->left = newNode(6);
    root->right->right = newNode(7);
    root->right->left->right = newNode(8);
    printf("Sum of the Binary Tree :: %d \n",sumBT(root));
}
