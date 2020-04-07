/*
Find the Least Common Ancestor of two struct nodes in a Binary Tree....
Time complexity :: O(n)
Space complexity :: O(n).....recursive calls
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
struct node* getLCA(struct node *root,int p,int q)
{
	if(!root)
		return NULL;

	if(root->data==p || root->data==q)
		return root;

	struct node *left = getLCA(root->left,p,q);

	struct node *right = getLCA(root->right,p,q);

	if(left && right)
		return root;

	return left ? left : right;
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

				LCA=getLCA(root,p,q);

				printf("\n Least Common Ancestor :: %d \n",LCA->data);
				break;
		}
	}
	while(ch<4);
}
