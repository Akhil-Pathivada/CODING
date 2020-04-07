/*
Get the median from a stream of numbers (running integers)

Given that integers are read from a data stream. Find median of elements read so for in efficient way.
For simplicity assume there are no duplicates. For example, let us consider the stream 5, 15, 1, 3....


Time Complexity  : O(n)+O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *left,*right;
};

int getPredecessor(struct node *root)
{
	for( ; root->right; root=root->right);
	
	return root->data;
}

int getSuccessor(struct node *root)
{
	for( ;root->left; root=root->left);
	
	return root->data;
}

int deleteNode( struct node *parent, struct node *child, int *treeCount) // O(1)
{
	int temp=child->data;
	
	--*treeCount;
	
	free(child);
	return temp;
}

int findInOrderPredecessor( struct node *prec, int *leftTreeCount) // O(n)
{
	struct node *parent=prec;
	
	prec=prec->left;
	
	if(!prec->right)
	{
		parent->left=prec->left;

		return deleteNode(parent,prec,leftTreeCount);
	}
	
	for( ;prec->right ;prec=prec->right)
		parent=prec;
		
	parent->right=prec->left;
	
	return deleteNode(parent,prec,leftTreeCount);	
}

int findInOrderSuccessor( struct node *succ, int *rightTreeCount) // O(n)
{
	struct node *parent=succ;
	
	succ=succ->right;
	
	if(!succ->left)
	{
		parent->right=succ->right;
		
		return deleteNode(parent,succ,rightTreeCount);
	}
	
	for( ;succ->left ;succ=succ->left)
		parent=succ;
		
	parent->left=succ->right;
	
	return deleteNode(parent,succ,rightTreeCount);	
}

void insertNode( struct node **root, int *leftTreeCount, int *rightTreeCount, int val) // O(n)
{
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->left=nn->right=NULL;
	
	if(!(*root))
	{
		*root=nn;
		*leftTreeCount=*rightTreeCount=0;
		return;
	}
	
	struct node *parent,*curr=*root;
	
	while(curr)
	{
		parent=curr;
		curr = val < curr->data ? curr->left : curr->right; 
	}
	
	if(val < parent->data)
		parent->left=nn;
	else
		parent->right=nn;
		
	val < (*root)->data ? ++*leftTreeCount : ++*rightTreeCount;
}

void balanceTree( struct node *root, int *leftTreeCount, int *rightTreeCount) // O(1)
{
	int diff = (*leftTreeCount) - (*rightTreeCount);
	
	if(diff==0 || diff== -1 || diff==1)
		return;
	
	int temp=root->data;
	
	root->data = (diff > 1) ? findInOrderPredecessor(root,leftTreeCount) : findInOrderSuccessor(root,rightTreeCount);
	
	insertNode(&root,leftTreeCount,rightTreeCount,temp);
}

void printMedian( struct node *root, int index, int leftTreeCount, int rightTreeCount) // O(1)
{
	int diff = leftTreeCount-rightTreeCount;
	
	if(diff==0)
		printf(" Median at %d is : %d \n", index,root->data);
		
	else if(diff==1)
		printf(" Median at %d is : %d,%d \n", index, getPredecessor(root->left), root->data);	
	
	else
		printf(" Median at %d is : %d,%d \n", index,root->data, getSuccessor(root->right));	
}

void getMedian( int *arr, int n)
{
	struct node *root;
	
	int leftTreeCount,rightTreeCount;
	
	for(int i=0; i<n ;++i)
	{
		insertNode(&root,&leftTreeCount,&rightTreeCount,arr[i]);
		
		balanceTree(root,&leftTreeCount,&rightTreeCount);
	
		printMedian(root,i,leftTreeCount,rightTreeCount);		
	}
}

void main()
{
	int arr[]={21,10,15,3,4,14,32,45,11,12,16}; // running integers
	int size=sizeof(arr)/sizeof(*arr);
	
	getMedian(arr,size);
}
