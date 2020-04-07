// Searching in Splay Trees.....

#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *left,*right;
};

struct node *newNode(int data)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	nn->left = nn->right =NULL;
	
	return nn;
}

struct node *leftRotate(struct node *x)
{
	struct node *y = root->left;	
}

struct node* splayNode( struct node *root, int key)
{
	if(!root)
		return NULL;
		
	if(root->data == key)
		return root;
	
	else if(key < root->data)
	{
		if(!root->left)
			return root;
			
		// Zig-Zig rotation
		if(key < root->left->key)
		{
			root->left->left = splayNode(root->left->left,key);
			
		}
		
		// Zig-Zag rotation
		if(key > )
			root->left->right = splayNode(root->left->right,key);	
			
	} 
}

void main()
{
	struct node *root = newNode(10);
	root->left = newNode(1);
	root->right = newNode(12);
	root->left->left = newNode(0);
	root->left->right = newNode(9);
	root->left->right->left = newNode(3);
	root->left->right->right = newNode(10);
	root->left->right->left->left = newNode(2);
	root->left->right->left->right = newNode(5);
	root->left->right->left->right->right = newNode(7);
	root->left->right->left->right->right->left = newNode(6);
	root->left->right->left->right->right->right = newNode(8);
	
	printf("\n Tree before Search : ");
	
	PreOrder(root);
	
	int key = 7; // key to search
	
	searchNode(root,key);
	
	printf("\n Tree after Search : ");
	
	PreOrder(root);
}


