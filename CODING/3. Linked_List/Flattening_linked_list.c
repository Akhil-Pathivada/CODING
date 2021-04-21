/*
Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer ).
Write a function flatten() to flatten the lists into a single linked list. The flattened linked list should also be sorted.

*/

#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	
	struct node *right,*down;
};	

void pushNode( struct node **head_ref, int data)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->right = NULL;
	
	nn->down = *head_ref;
	
	*head_ref = nn;
}

void printList(struct node *curr)
{
	for( ;curr; curr=curr->down)
		printf(" %d->",curr->data);
}

struct node* Merge( struct node *a, struct node *b)
{	
	if(!a)
		return b;
	if(!b)
		return a;
	
	struct node *res;
	
	if(a->data < b->data)
	{	
		res = a;
		
		res->down = Merge(a->down, b);
	}
	else
	{
		res = b;
		
		res->down = Merge(a,b->down);
	}
	
	return res;
}

struct node* Flatten(struct node* root)
{
	if(!root || !root->right)
		return root;
	
	return Merge( root, Flatten(root->right));
}

void main()
{
	struct node *root=NULL;
	
	pushNode(&root,30);
	pushNode(&root,8);
	pushNode(&root,7);
	pushNode(&root,5);
	
	pushNode(&(root->right),20);
	pushNode(&(root->right),10);
	
	pushNode(&(root->right->right),50);
	pushNode(&(root->right->right),22);
	pushNode(&(root->right->right),19);
	
	pushNode(&(root->right->right->right),45);
	pushNode(&(root->right->right->right),40);
	pushNode(&(root->right->right->right),35);
	pushNode(&(root->right->right->right),28);
	
	root = Flatten(root);
	
	printList(root);
}
