/*
Convert a Sorted Array into BST

Time Complexity : O(n)
Space Complexity : O(n)
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
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->left = nn->right = NULL;

	return nn;
}

struct node *makeBST( int *arr, int start, int end) // O(n)
{
	if(start > end)
		return NULL;

	int mid = (start+end)/2;

	struct node *root = newNode(arr[mid]);

	root->left = makeBST(arr,start,mid-1);
	
	root->right = makeBST(arr,mid+1,end);

	return root;
}

void PreOrder(struct node *root)
{
	if(!root)
		return;
	
	printf(" %d",root->data);
	
	PreOrder(root->left);
	
	PreOrder(root->right);
}

int main()
{
	int arr[] = {1, 2, 3, 4, 5, 6, 7};
	
	int n = sizeof(arr)/sizeof(*arr);

	PreOrder(makeBST(arr, 0, n-1));
}
