/*
Given two Binary Search Trees(BST), print the elements of both BSTs in sorted form. 
The expected time complexity is O(m+n) where m is the number of nodes in first tree and n is the number of nodes in second tree. 
Maximum allowed auxiliary space is O(height of the first tree + height of the second tree).

*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

#define min(a,b)  a<b ? a : b

struct node 
{
	int data;
	struct node *left,*right;
};

struct snode
{
	struct node *tptr;
	struct snode *next;
};

struct node *newNode(int val)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->left = nn->right = NULL;

	return nn;
}

struct node *Pop(struct snode **head)
{
	if(!*head)
		return NULL;
	
	struct node *root = (*head)->tptr;
	
	(*head) = (*head)->next;
	
	return root;
}

void Push(struct snode **head, struct node *root)
{
	struct snode *nn = (struct snode*)malloc(sizeof(struct snode));
	
	nn->tptr = root;
	
	nn->next = *head;
	
	*head = nn;
}

bool isStackEmpty(struct snode *stack)
{
	return (stack==NULL);
}

void mergeTwoBST( struct node *root1, struct node *root2)
{
	struct snode *s1,*s2;
		
	struct node *temp1, *temp2;

	bool done = false;
		
	s1 = s2 = NULL;
	
	while(!done)
	{
		for( ; root1; root1=root1->left)
			Push(&s1,root1);	
		
		for( ; root2; root2=root2->left)
			Push(&s2,root2);
		
		
		bool e1 = isStackEmpty(s1);
		
		bool e2 = isStackEmpty(s2);
		
		if(!e1)
			temp1 = Pop(&s1);
			
		if(!e2)
			temp2 = Pop(&s2);

		if(temp1 && temp2)
		{
			int val = min(temp1->data,temp2->data);
			
			printf(" %d,",val);
			
			if(val == temp1->data)
			{
				root1 = temp1->right;
				
				Push(&s2,temp2);	
			}
			else
			{
				root2 = temp2->right;
				
				Push(&s1,temp1);
			}
		}
		else if(temp1)
		{
			root1 = temp1->right;
			
			printf(" %d,",temp1->data);
		}
		else if(temp2)
		{
			root2 = temp2->right;
	
			printf(" %d,",temp2->data);
		}
		
		if(e1 && e2)
			done = true;
			
		temp1 = temp2 = NULL;
	}
}

void main()
{
	struct node *root1 = newNode(8);
	root1->left = newNode(2);
	root1->left->left = newNode(1);
	root1->right = newNode(10);
	
	struct node *root2 = newNode(5);
	root2->left = newNode(3);
	root2->left->left = newNode(0);
	
	mergeTwoBST(root1,root2);
}
