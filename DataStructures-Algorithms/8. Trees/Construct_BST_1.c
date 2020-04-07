/*
Given PreOrder & InOrder, create the BST

Time Complexity :: O(n^3)
Space Complexity :: O(n).....(RECURSION)
*/

#include<stdio.h>
#include<stdlib.h>
#define N 9

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

void PostOrder(struct node *root)
{
	if(!root)
	
	PostOrder(root->left);
	
	PostOrder(root->right);

	printf(" %d,",root->data);
}

int getRoot(int *preorder,int *inorder,int min,int max) // O(n^2)
{
	for(int i=0; i<N; ++i)
	{
		for(int j=min; j<=max; ++j)
		{
			if(preorder[i] == inorder[j])
				return j;
		}
	}
	return -1;
}

struct node *createTree(int *preorder, int *inorder, int MIN, int MAX) // O(n)
{
	int pos = getRoot(preorder,inorder,MIN,MAX);

	if(pos == -1)
		return NULL;

	struct node *root = newNode(inorder[pos]);

	root->left = createTree(preorder,inorder,MIN,pos-1);

	root->right = createTree(preorder,inorder,pos+1,MAX);

	return root;
}

void main()
{
	int preorder[N],inorder[N];

	printf(" enter PreOrder :");

	for(int i=0; i<N; i++)
		scanf("%d",&preorder[i]);

	printf(" enter InOrder : ");

	for(int i=0; i<N; i++)
		scanf("%d",&inorder[i]);

	struct node *root = createTree(preorder,inorder,0,N);

	PostOrder(root);
}
