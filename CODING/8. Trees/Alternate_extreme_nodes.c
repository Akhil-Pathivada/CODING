/*
Print extreme nodes of each level of Binary Tree in alternate order

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
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->left = nn->right = NULL;
	
	return nn;
}

struct node** createQueue(int *front,int *rear,int N)
{
	struct node **queue = (struct node**)calloc(N,sizeof(struct node*));
	
	*front = *rear = 0;
	
	return queue;
}

void enQueue(struct node **queue,struct node *root,int *rear)
{
	queue[(*rear)++] = root;
}
 
struct node* deQueue(struct node **queue,int *front)
{
	return queue[(*front)++];
}

bool isQueueEmpty(int *front,int *rear)
{
	return (*front)==(*rear);
}

int sizeOfQueue(int *front,int *rear)
{
	return (*rear)-(*front);
}

void printExtremeNodes(struct node *root,int N)
{
	int front, rear;
	
	struct node **queue = createQueue(&front,&rear,N);

	enQueue(queue,root,&rear);
	
	bool flag = false;

	while(!isQueueEmpty(&front,&rear))
	{
		int nodeCount = sizeOfQueue(&front,&rear);
		
		int n = nodeCount;

		while(n--)
		{
			struct node *curr = deQueue(queue, &front);

			if(curr->left)
				enQueue(queue, curr->left, &rear);
				
			if(curr->right)
				enQueue(queue,curr->right,&rear);

			if(!flag && !n)
				printf(" %d", curr->data);
				
			if(flag && (n == nodeCount-1))
				printf(" %d", curr->data);
		}
		flag = !flag;
	}
}

int getSizeOfTree(struct node *root)
{
	return root ? 1 + getSizeOfTree(root->left) + getSizeOfTree(root->right) : 0;
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
	root->left->left->left = newNode(80);
	root->right->right->right = newNode(90);
	root->left->left->left->right=newNode(111);
	root->right->right->right->left=newNode(112);

	int N = getSizeOfTree(root);
	
	printExtremeNodes(root,N);
}
