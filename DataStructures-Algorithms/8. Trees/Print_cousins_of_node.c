/*
Print cousins of a given node in Binary Tree (Single Traversal)

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
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->left=nn->right=NULL;

	return nn;
}

struct node **createQueue(int *front,int *rear,int N)
{
	struct node **queue=(struct node**)calloc(N,sizeof(struct node*));

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

void printCousins(struct node *root, struct node *targetNode, int N)
{
	int front,rear;

	struct node **queue = createQueue(&front,&rear,N);

	bool found = false;

	enQueue(queue,root,&rear);

	while(!isQueueEmpty(&front,&rear) && !found)
	{
		int size = sizeOfQueue(&front,&rear);

		while(size--)
		{
			struct node *temp = deQueue(queue,&front);

			if(temp->left == targetNode || temp->right == targetNode)
				found = true;
			else
			{
				if(temp->left)
					enQueue(queue,temp->left,&rear);

				if(temp->right)
					enQueue(queue,temp->right,&rear);
			}
		}
	}

	while(!isQueueEmpty(&front,&rear))
		printf(" %d,",deQueue(queue,&front)->data);
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

	struct node *targetNode = root->right->right;

	printCousins(root, targetNode, N);
}
