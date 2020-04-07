/*
Program for insertion in AVL Trees....

Time Complexity : O(logN)
Space Complexity : O(logN)
*/

#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data,height;
	struct node *left,*right;
};

struct node *newNode( int key)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));

	nn->data = key;
	
	nn->height = 1;
	
	nn->left = nn->right = NULL;
	
	return nn;
}

int max( int a, int b)
{
	return a>b ? a : b;
}

int getHeight( struct node *root)
{
	return root ? root->height : 0;
}

int getBalanceFactor( struct node *root)
{
	if(!root)
		return 0;
	
	return getHeight(root->left) - getHeight(root->right);
}

struct node *rightRotate( struct node *root, struct node *leftChild) // Clockwise Rotation
{
	struct node *temp = leftChild->right;

	leftChild->right = root;

	root->left = temp;
	
	root->height = 1 + max( getHeight(root->left), getHeight(root->right));
	
	leftChild->height = 1 + max( getHeight(leftChild->left), getHeight(leftChild->right));
	
	return leftChild;
}

struct node *leftRotate( struct node *root, struct node *rightChild) // Anti-Clockwise Rotation
{
	struct node *temp = rightChild->left;

	rightChild->left = root;

	root->right = temp;
	
	root->height = 1 + max( getHeight(root->left), getHeight(root->right));
	
	rightChild->height = 1 + max( getHeight(rightChild->left), getHeight(rightChild->right));
	
	return rightChild;
}

struct node *insertNode( struct node *root, int key)
{
	if(!root)
		return newNode(key);
	
	if(key < root->data)
		root->left = insertNode(root->left,key);
		
	else if(key > root->data)
		root->right = insertNode(root->right,key);
		
	root->height = 1 + max( getHeight(root->left), getHeight(root->right));
		
	int BF = getBalanceFactor(root);

	
	 // L-L imBalance
	if( BF > 1 && key < root->left->data)
		return rightRotate(root,root->left);

	
	// R-R imBalance
	if( BF < -1 && key > root->right->data) 
		return leftRotate(root,root->right);

		
	// L-R imBalance
	if( BF > 1 && key > root->left->data) 
	{
		root->left = leftRotate( root->left, root->left->right);
		
		return rightRotate(root,root->left);	
	}

	
	// R-L imBalance
	if( BF < -1 && key < root->right->data) 
	{
		root->right = rightRotate( root->right, root->right->left);
		
		return leftRotate(root,root->right);
	}
		
	return root;
}

void PreOrder( struct node *root)
{
	if(!root)
		return;
		
	printf(" %d,",root->data);
	
	PreOrder(root->left);

	PreOrder(root->right);
}

void main()
{
	int nodes[] = {21,26,30,9,4,14,28,18,15,10,2,3,7};

	int size = sizeof(nodes)/sizeof(*nodes);
	
	struct node *root=NULL;
	
	for(int i=0; i<size; ++i)
		root = insertNode(root,nodes[i]);
	
	PreOrder(root);
}
