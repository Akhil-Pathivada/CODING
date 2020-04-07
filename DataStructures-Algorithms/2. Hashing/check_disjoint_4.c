/*
Check whether two arrays are Disjoint or not....

Time Complexity : O(n*logm)
Space Complexity : O(m)
*/
#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

struct node 
{
	int data;
	struct node *left,*right;
};

void createBST(struct node **root,int val)
{
	struct node *nn=(struct node *)malloc(sizeof(struct node));
	nn->data=val;
	nn->left = nn->right = NULL;

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

bool searchBST(struct node *root,int target) // O(logm)
{
	if(!root)
		return false;

	if(root->data==target)
		return true;

	else if(root->data > target)
		searchBST(root->left,target);

	else
		searchBST(root->right,target);
}

bool checkDisjoint(struct node *root,int arr2[],int n) 
{
	for(int i=0;i<n;i++)
	{
		if(searchBST(root,arr2[i]))
			return true;
	}
	return false;
}

void PreOrder(struct node *root)
{
	if(root)
	{
		printf("%d",root->data);
		PreOrder(root->left);
		PreOrder(root->right);
	}
}

int main()
{
	int arr1[]={2,4,1,5,3};
	int arr2[]={12,7,9,19,29,15,5};

	struct node *root=NULL;

	for(int i=0;i<5;i++)
		createBST(&root,arr1[i]);

	printf(checkDisjoint(root,arr2,7) ? "TRUE" : "FALSE"); 
}
