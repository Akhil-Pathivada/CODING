/*
Level Order traversal in a Spiral form

 Time Complexity : O(n)
 Space Complexity : O(n)+O(n)+O(n).......(2 stacks + Recursion)
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
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->left = nn->right = NULL;

	return nn;
}

struct node **createStack(int N,int *top)
{
	struct node **stack = (struct node **)malloc(sizeof(struct node*)*N);

	*top = -1;

	return stack;
}

void Push(struct node **stack,struct node *newnode,int *top)
{
	stack[++(*top)] = newnode;
}

struct node *Pop(struct node **stack,int *top)
{
	return stack[(*top)--];
}

bool isStackEmpty(int top)
{
	return top == -1;
}

void getSpiralOrder(struct node *root,int N)
{
	int top1,top2;

	struct node **stack1 = createStack(N,&top1);

	struct node **stack2 = createStack(N,&top2);

	Push(stack1,root,&top1);

	struct node *temp;
	
	while(!isStackEmpty(top1) || !isStackEmpty(top2))
	{
		while(!isStackEmpty(top1))
		{
			temp = Pop(stack1,&top1);

			printf(" %d,",temp->data);

			if(temp->left)
				Push(stack2,temp->left,&top2);

			if(temp->right)
				Push(stack2,temp->right,&top2);
		}
		while(!isStackEmpty(top2))
		{
			temp = Pop(stack2,&top2);

			printf(" %d,",temp->data);

			if(temp->right)
				Push(stack1,temp->right,&top1);

			if(temp->left)
				Push(stack1,temp->left,&top1);
		}
	}
}

int sizeOfTree(struct node *root)
{
	return root ? 1 + sizeOfTree(root->left) + sizeOfTree(root->right) : 0;
}

void main()
{
	struct node *root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->left->right = newNode(50);
	root->right->left = newNode(60);
	root->right->right = newNode(70);	
	root->right->right->right = newNode(90);	
	root->left->left->left = newNode(120);
	
	int N = sizeOfTree(root);

	getSpiralOrder(root,N);
}
