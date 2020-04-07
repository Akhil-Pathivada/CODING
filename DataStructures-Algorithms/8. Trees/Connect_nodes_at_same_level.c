/*
Write a function to connect all the adjacent nodes at the same level in a binary tree. 

Time Complexity : O(n)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct BT
{
	int data;
	struct BT *left;
	struct BT *right;
	struct BT *nextRight;
};

struct Queue
{
	int level;
	struct BT *node;
};

struct BT* newNode(int data)
{
	struct BT *nn = (struct BT*)malloc(sizeof(struct BT));
	
	nn->data = data;
	
	nn->left = nn->right = nn->nextRight = NULL;
	
	return nn;
}

struct Queue* createQueue( int *front, int *rear, int N)
{
	struct Queue *queue = (struct Queue*)calloc(N,sizeof(struct Queue));
	
	*front = *rear = 0;
	
	return queue;
}

void enQueue( struct Queue *queue, struct BT *root, int *rear, int level)
{
	queue[*rear].node = root;
	
	queue[*rear].level = level; 
	
	++*rear; 	
}

struct Queue* deQueue( struct Queue *queue, int *front)
{
	++*front;
		
	return &queue[*front-1];
}

bool isQueueEmpty( int front, int rear)
{
	return (front == rear);
}

void printNextNodes( struct BT *root)
{
	if(!root)
		return;
	
	if(root->nextRight)	
		printf(" [%d,%d]",root->data,root->nextRight->data);
	
	printNextNodes(root->left);
	
	printNextNodes(root->right);
}

void connectNodes( struct BT *root, int N)
{
	int front,rear;

	struct Queue *queue = createQueue(&front,&rear,N);
	
	enQueue(queue,root,&rear,0);
	
	struct Queue *t;
	
	struct BT *curr;
	
	while(!isQueueEmpty(front,rear))
	{
		t = deQueue(queue,&front);
		
		curr = t->node;
		
		int parentLevel = t->level; 
			
		if(curr->left)
			enQueue(queue,curr->left,&rear,!parentLevel);
			
		if(curr->right)
			enQueue(queue,curr->right,&rear,!parentLevel);
	}
	
	front = 0;
	
	struct Queue *prev = NULL;
	
	while(!isQueueEmpty(front,rear))
	{
		t = deQueue(queue,&front);
		
		curr = t->node;
		
		if(prev && prev->level == t->level)
			prev->node->nextRight = curr;
			
		prev = t;
	}
		
	printNextNodes(root);
}

int sizeOfTree(struct BT* root)
{
	return root ? 1 + sizeOfTree(root->left) + sizeOfTree(root->right) : 0;
}

void main()
{
	struct BT *root = newNode(10); 
  	root->left = newNode(5); 
  	root->left->left = newNode(3);
  	root->left->right = newNode(6);
  	root->left->left->left = newNode(1); 
  	root->right = newNode(15); 
  	root->right->left = newNode(13); 
  	root->right->right = newNode(20); 
  	root->right->right->left = newNode(18); 
  	
  	int N = sizeOfTree(root);
  	
  	connectNodes(root,N);
}
