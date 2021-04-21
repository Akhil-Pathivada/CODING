// Delete the Binary Tree Completely......
#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *left,*right;
};

struct node *newNode(int val)
{
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->left=nn->right=NULL;
	return nn;
}

void deleteTree(struct node *root)
{
	if(!root)
		return;
	deleteTree(root->left);
	deleteTree(root->right);
	free(root);
}
int main()
{
	struct node *root=newNode(10);
	root->left        = newNode(2); 
    	root->right       = newNode(10); 
    	root->left->left  = newNode(20); 
    	root->left->right = newNode(1); 
   	root->right->right = newNode(-25); 
    	root->right->right->left   = newNode(3); 
    	root->right->right->right  = newNode(4); 
	deleteTree(root);
	printf("Tree was Deleted\n");
}
