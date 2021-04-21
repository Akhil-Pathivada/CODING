/*
Given a Binary Tree, return following value for it.
1) For every level, compute sum of all leaves if there are leaves at this level. Otherwise ignore it.
2) Return multiplication of all sums.

Time Complexity : O(n)
Space Complexity : O(n)+O(n)
*/

#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *left,*right;
};

struct node *newNode(int val)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->left=nn->right=NULL;

	return nn;
}

struct node **createQueue(int *front,int *rear,int N)
{
	struct node **queue = (struct node**)calloc(N,sizeof(struct node*));

	*front=*rear=0;

	return queue;
}

void enQueue(struct node **queue,struct node *root,int *rear)
{
	queue[(*rear)++]=root;
}

struct node* deQueue(struct node **queue,int *front)
{
	return queue[(*front)++];
}

bool isQueueEmpty(int *front,int *rear)
{
	return ((*front)==(*rear));
}

int sizeOfQueue(int *front,int *rear)
{
	return ((*rear)-(*front));
}

int getSumProduct(struct node *root,int N)
{
	int front,rear;
	
	int product=1;

	struct node **queue = createQueue(&front,&rear,N);	

	enQueue(queue,root,&rear);

	while(!isQueueEmpty(&front,&rear))
	{
		int size = sizeOfQueue(&front,&rear);
		int levelSum = 0;

		while(size--)
		{
			struct node *temp = deQueue(queue,&front);

			if(!temp->left && !temp->right)
				levelSum += temp->data;

			if(temp->left)
				enQueue(queue,temp->left,&rear);

			if(temp->right)
				enQueue(queue,temp->right,&rear);
		}
		product *= (levelSum>0)?levelSum:1;
	}
	return product;
}

int sizeOfTree(struct node *root)
{
	return root ? (1+sizeOfTree(root->left)+sizeOfTree(root->right)) : 0;
}

void main()
{
	struct node *root=newNode(2);
	root->left=newNode(7);
	root->right=newNode(5);
	root->left->left=newNode(8);
	root->left->right=newNode(6);
	root->right->right=newNode(9);	
	root->left->right->left=newNode(1);
	root->left->right->right=newNode(11);
	root->right->right->left=newNode(4);
	root->right->right->right=newNode(10);
	
	int N = sizeOfTree(root);

	printf(" PRODUCT : %d ", getSumProduct(root,N));
}
