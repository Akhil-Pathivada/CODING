/*
Find the Least Common Ancestor of two struct nodes in a Binary Search Tree....

Time complexity :: O(n) (iterative&recursion)
Space complexity :: O(n).....recursive calls
Space complexity :: O(1)......iterative version
*/

#include<stdio.h>
#include<stdlib.h>

struct node 
{
	int data;
	struct  node *left,*right;
}*root;

void Insert(int val)
{
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->left=nn->right=NULL;

	if(!root)
	{
		root=nn;
		return;
	}

	struct node *curr=root,*parent;

	while(curr)
	{
		parent=curr;

		curr = val < curr->data ? curr->left : curr->right;
	}

	if(val < parent->data)
		parent->left=nn;
	else
		parent->right=nn;
	
}

void Preorder(struct node *root)
{
	if(!root)
		return;
		
	printf(" %d,",root->data);
		
	Preorder(root->left);
	Preorder(root->right);
}

struct node* recursiveLCA(struct node *root,int p,int q)
{
	if(!root)
		return NULL;

	if(root->data > p && root->data > q)
		return recursiveLCA(root->left,p,q);

	if(root->data < p && root->data < q)
		return recursiveLCA(root->right,p,q);

	return root;
}

struct node* iterativeLCA(struct node *root,int p,int q)
{
	while(root)
	{
		if(root->data > p && root->data > q)
			root=root->left;

		else if(root->data < p && root->data < q)
			root=root->right;

		else
			break;
	}
	return root;
}

void main()
{
	int val,ch,p,q;
	struct node *LCA;
	do
	{
		printf("\n\t1.Insert");
		printf("\n\t2.PreOrder");
		printf("\n\t3.Find LCA");
		printf("\nEnter U R Choice : ");
		scanf("%d",&ch);

		switch(ch)
		{
			case 1:
				printf("\n Enter Node :: ");
				scanf("%d",&val);

				Insert(val);
				break;

			case 2:
				Preorder(root);
				break;

			case 3:
				printf("\nEnter two nodes : ");
				scanf("%d%d",&p,&q);

				LCA = recursiveLCA(root,p,q);

				printf("\n Least Common Ancestor :: %d \n",LCA->data);

				LCA = iterativeLCA(root,p,q);

				printf("\n Least Common Ancestor :: %d \n",LCA->data);

				break;
		}
	}
	while(ch<4);
}
