/*
Get the InOrder of the Binary Tree....using iterative

Time Complexity : O(n)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

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

struct node **createStack(int *top,int N)
{
	struct node **stack=(struct node**)malloc(sizeof(struct node*)*N);

	*top=-1;

	return stack;
}

void Push(struct node **stack,struct node *root,int *top)
{
	stack[++*top]=root;
}

bool isStackEmpty(int top)
{
	return (top==-1);
}

struct node* Pop(struct node **stack,int *top)
{
	return stack[(*top)--];
}

void InOrder(struct node *root,int N)
{
	int top;

	struct node **stack = createStack(&top,N);

	struct node *temp ,*curr = root;

	bool done=false;
	
	while(!done)
	{
		for( ;curr; curr=curr->left)
			Push(stack,curr,&top);	
		
		if(!isStackEmpty(top))
		{
			temp = Pop(stack,&top);

			printf(" %d,",temp->data);
		}

		else
			done = true;
			
		curr = temp->right;
	}
}

int getCount(struct node *root)
{
	return root ? (1+getCount(root->left)+getCount(root->right)) :0;
}

void main()
{
	struct node *root=newNode(20);
	root->left=newNode(15);
	root->left->right=newNode(17);
	root->left->right->left=newNode(16);
	root->left->left=newNode(11);
	root->right=newNode(33);
	root->right->left=newNode(25);
	root->right->left->right=newNode(29);
	root->right->right=newNode(35);
	
	int N=getCount(root);
	InOrder(root,N);
}
