//Insertion in Binary Search Tree......

#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
	int data;
	struct node *left;
	struct node *right;
}Node;

Node *root;

void Insert(int val)
{
	Node *nn=(Node*)malloc(sizeof(Node));
	nn->data=val;
	nn->left=nn->right=NULL;
	if(!root)
	{
		root=nn;
		return;
	}
	Node *curr=root,*parent;
	while(curr)
	{
		parent=curr;
		curr=val<curr->data ? curr->left : curr->right;
	}
	if(val < parent->data)
		parent->left=nn;
	else
		parent->right=nn;
	
}

void Preorder(Node *root)
{
	if(!root)
		return;

	printf(" %d,",root->data);
	Preorder(root->left);
	Preorder(root->right);
}

void main()
{
	int val,ch;
	do
	{
		printf("\n\t1.Insert ");
		printf("\n\t2.PREORDER");
		printf("\nEnter U R Choice :: ");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:
				printf("\nEnter the value to insert :: ");
				scanf("%d",&val);
				Insert(val);
				break;
			case 2:
				Preorder(root);
				break;
		}
		
	}while(ch<3);
}
