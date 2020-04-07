/*
Convert a BST into balanced BST....

Time Complexity :: O(n)
Space Complexity :: O(n)..........Recursion

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

struct node *makeBST(int *arr,int start,int end)
{
	if(start > end)
		return NULL;

	int mid=(start+end)/2;

	struct node *root=newNode(arr[mid]);

	root->left=makeBST(arr,start,mid-1);

	root->right=makeBST(arr,mid+1,end);

	return root;
}

void insertArray(struct node *root,int *arr,int *index)
{
	if(!root)
		return;
	
	insertArray(root->left,arr,index);

	arr[++*index]=root->data;

	insertArray(root->right,arr,index);

	free(root);
}

void PreOrder(struct node *root)
{
	if(!root)
		return;

	printf(" %d,",root->data);
	
	PreOrder(root->left);
	PreOrder(root->right);
}

int sizeOfTree(struct node *root) // O(n)
{
	return root ? (1+sizeOfTree(root->left)+sizeOfTree(root->right)) : 0;
}

int main()
{
	struct node *root=newNode(4);
	root->left=newNode(2);
	root->right=newNode(6);
	root->left->left=newNode(1);
	root->left->left->left=newNode(0);
	root->right->left=newNode(5);

	int *arr,index=-1;

	int N=sizeOfTree(root);

	arr=(int*)malloc(sizeof(int)*N);

	insertArray(root,arr,&index);

	printf("\n balanced BST ::");

	PreOrder(makeBST(arr,0,N-1));
}
