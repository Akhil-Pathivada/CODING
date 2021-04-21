/*
Group all the occurences of an element order by their first occurence....

Time Complexity : O(n*logn)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node 
{
	int data,freq;
	struct node *left,*right;
};

void createBST(struct node **root,int val)
{
	struct node *nn=(struct node *)malloc(sizeof(struct node));

	nn->data=val;
	++nn->freq;
	nn->left=nn->right=NULL;

	if(!(*root))
	{
		*root=nn;
		return;
	}

	struct node *curr=*root,*parent=*root;

	while(curr)
	{
		parent=curr;

		curr=(curr->data > val)? curr->left:curr->right;
	}

	if(parent->data > val)
		parent->left=nn;
	else
		parent->right=nn;
}

struct node* searchBST(struct node *root,int target) // O(logn)
{
	if(!root)
		return NULL;

	if(root->data==target)
	{
		++root->freq;
		return root;
	}

	else if(root->data > target)
		searchBST(root->left,target);
	else
		searchBST(root->right,target);
}

void groupOccurences(int arr[],int res[],struct node *root,int N) // O(n)
{
	for(int i=0;i<N;i++)
	{
		struct node *node=searchBST(root,arr[i]);

		while(--node->freq)
			*(res++)=arr[i];
	}
}

int main()
{
	int arr[]={3,6,1,2,3,4,1,2,1};

	int res[9];

	struct node *root=NULL;

	for(int i=0;i<9;i++)
	{
		if(!searchBST(root,arr[i]))
			createBST(&root,arr[i]);
	}

	groupOccurences(arr,res,root,9);

	for(int i=0;i<9;i++)
		printf(" %d,",res[i]);
}
