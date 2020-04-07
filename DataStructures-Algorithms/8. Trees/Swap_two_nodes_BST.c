/*

Two nodes in the BST are placed incorrectly, correct them...

Time Complexity :: O(n)
Space Complexity :: O(n)

*/

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

void Swap( int *aptr, int *bptr)
{
	int temp = *aptr;
	*aptr=*bptr;
	*bptr=temp;
}

void swapNodesBST( struct node *root, struct node **prev, struct node **first, struct node **middle, struct node **last)
{
	if(!root)
		return;
		
	swapNodesBST(root->left,prev,first,middle,last);
		
	if( *prev && root->data < (*prev)->data)
	{
		if(!*first)
		{
			*first = *prev;
			*middle = root;
		}
		else
			*last = root;
	}
		
	*prev = root;
	
	swapNodesBST(root->right,prev,first,middle,last);
}

void InOrder( struct node *root)
{
	if(!root)
		return;
	
	InOrder(root->left);
	
	printf(" %d,",root->data);
	
	InOrder(root->right);
}

void main()
{
	struct node *root=newNode(50);
	root->left=newNode(20);
	root->right=newNode(70);
	root->left->left=newNode(10);
	root->left->right=newNode(65);
	root->right->left=newNode(40);
	root->right->right=newNode(100);
	
	InOrder(root);
	
	struct node *prev,*first,*middle,*last;
	
	prev=first=middle=last=NULL;
	
	swapNodesBST(root,&prev,&first,&middle,&last);
	
	if(first && last)
		Swap( &first->data, &last->data);
	else
		Swap( &first->data, &middle->data);
	
	printf("\n");
	
	InOrder(root);
}
