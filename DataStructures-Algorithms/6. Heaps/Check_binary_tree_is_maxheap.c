/*
Given a binary tree, we need to check it has heap property or not, Binary tree need to fulfill the following two conditions for being a heap –

   1.It should be a complete tree (i.e. all levels except last should be full).
   2.Every node’s value should be greater than or equal to its child node (considering max-heap).

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

struct node *newNode(int data)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->left = nn->right = NULL;
	
	return nn;
}

struct node **createQueue( int *front, int *rear, int N)
{
	struct node **queue = (struct node **)malloc(sizeof(struct node*) * N);
	
	*front = *rear = 0;
	
	return queue;
}

void enQueue( struct node **queue, int *rear, struct node *nn)
{
	queue[(*rear)++] = nn;
}

struct node *deQueue( struct node **queue, int *front)
{
	return queue[(*front)++];
}

bool isQueueEmpty( int front, int rear)
{
	return front==rear;
}

int getSize(struct node *root)
{
	return root ? 1 + getSize(root->left) + getSize(root->right) : 0;
}

bool isCompleteBT( struct node *root)
{
	if(!root)
		return true;
		
	int front,rear,N;

	N = getSize(root);	
	
	struct node **queue = createQueue(&front,&rear,N);
	
	enQueue(queue,&rear,root);
	
	bool flag = false;
	
	while(!isQueueEmpty(front,rear))
	{
		struct node *temp = deQueue(queue,&front);
		
		if(temp->left)
		{
			if(flag)
				return false;
				
			enQueue(queue,&rear,temp->left);
		}
		else
			flag = true;
		
		if(temp->right)
		{
			if(flag)
				return false;
			
			enQueue(queue,&rear,temp->right);
		}
		else
			flag = true;
	}	
		
	return true;
}

bool isHeap( struct node *root)
{		
	if(!root->left && !root->right)
		return true;
		
	if(!root->right)
		return root->data >= root->left->data;
	
	if(root->data >= root->left->data && root->data >= root->right->data)
			return isHeap(root->left) && isHeap(root->right);
		
	return false;
}

bool checkHeapUtil(struct node *root)
{
	return isCompleteBT(root) && isHeap(root);
}

void main()
{
	 struct node* root = NULL; 
  	 root = newNode(10); 
  	 root->left = newNode(9); 
  	 root->right = newNode(8); 
  	 root->left->left = newNode(7); 
   	 root->left->right = newNode(6); 
   	 root->right->left = newNode(5); 
   	 root->right->right = newNode(4); 
   	 root->left->left->left = newNode(3); 
   	 root->left->left->right = newNode(2); 
   	 root->left->right->left = newNode(1); 
	
	printf(checkHeapUtil(root) ? " Yes " : " No ");
}
