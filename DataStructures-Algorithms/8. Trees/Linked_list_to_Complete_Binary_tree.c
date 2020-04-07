/*
Construct Complete Binary Tree from its Linked List Representation

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct LL
{
	int data;
	struct LL *next;
};

struct BT
{
	int data;
	struct BT *left,*right;
};

struct LL *appendList(int val)
{
	struct LL *nn = (struct LL*)malloc(sizeof(struct LL));
	
	nn->data = val;
	
	nn->next = NULL;

	return nn;
}

struct BT *newNode(int val)
{
	struct BT *nn = (struct BT*)malloc(sizeof(struct BT));
	
	nn->data = val;
	
	nn->left = nn->right = NULL;

	return nn;
}

struct BT **createQueue(int *front,int *rear,int N)
{
	struct BT **queue = (struct BT**)malloc(sizeof(struct BT*)*N);

	*front = *rear = 0;

	return queue;
}

void enQueue(struct BT **queue,int *rear,struct BT *node)
{
	queue[(*rear)++] = node;
}

struct BT* deQueue(struct BT **queue,int *front)
{
	return queue[(*front)++];
}

bool isQueueEmpty(int *front,int *rear)
{
	return (*front)==(*rear);
}

struct BT* createBT(struct LL *head,int N)
{
	int front,rear;

	struct BT **queue = createQueue(&front,&rear,N);

	struct BT *root = newNode(head->data);

	enQueue(queue,&rear,root);
	
	struct BT *temp;

	while(!isQueueEmpty(&front,&rear) && head)
	{
		temp = deQueue(queue,&front);
		
		head = head->next;
		
		temp->left = head ? newNode(head->data) : NULL;

		enQueue(queue,&rear,temp->left);
		
		head = head->next;
		
		temp->right = head ? newNode(head->data) : NULL;

		enQueue(queue,&rear,temp->right);
	}
	return root;
}

int getLength(struct LL *head)
{
	int len = 0;

	for( ; head; head=head->next)
		len++;

	return len;
}

void PreOrder(struct BT *root)
{
	if(!root)
		return;

	printf(" %d,",root->data);

	PreOrder(root->left);
	
	PreOrder(root->right);
}

void main()
{
	struct LL *head = appendList(10);
	head->next = appendList(12);
	head->next->next = appendList(15);
	head->next->next->next = appendList(25);
	head->next->next->next->next = appendList(30);
	head->next->next->next->next->next = appendList(36);

	PreOrder(createBT(head, getLength(head)));
}
