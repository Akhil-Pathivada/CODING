/*
Get the Level of a Key in Binary Search Tree......

Time Complexity :: O(n)
Space Complexity :: O(n) ....RECURSION CALLS
*/
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
		curr=val<curr->data?curr->left:curr->right;
	}
	if(val < parent->data)
		parent->left=nn;
	else
		parent->right=nn;
	
}
void Preorder(Node *root)
{
	if(root)
	{
		printf(" %d,",root->data);
		Preorder(root->left);
		Preorder(root->right);
	}
}
int getLevel(Node *root,int key,int level)
{
	if(!root)
		return -1;
		
	if(root->data == key)
		return level;
		
	int flag = getLevel(root->left, key, level+1);
	
	if(flag != -1)
		return flag;
	
	return getLevel(root->right, key, level+1);
}
void main()
{
	int val,ch,key;
	do
	{
		printf("\n\t1.Insert ");
		printf("\n\t2.PREORDER");
		printf("\n\t3.Get Level of the Key");
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
			case 3:
				printf("\nEnter the key :: ");
				scanf("%d",&key);
				printf("\n** Level of the Key '%d' is :: %d\n",key,getLevel(root,key,1));
		}
	}while(ch<4);
}
