/*
Construct a Linked List  from its Binary Tree  Representation....(LEVEL ORDER)

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
	
	nn->data=val;
	
	nn->next=NULL;

	return nn;
}

struct BT *newNode(int val)
{
	struct BT *nn = (struct BT*)malloc(sizeof(struct BT));
	
	nn->data=val;
	
	nn->left=nn->right=NULL;
	
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
	queue[(*rear)++]=node;
}

struct BT* deQueue(struct BT **queue,int *front)
{
	return queue[(*front)++];
}

bool isQueueEmpty(int *front,int *rear)
{
	return ((*front)==(*rear));
}

struct LL* createLL(struct BT *root,int N)
{
	int front,rear;

	struct BT **queue = createQueue(&front,&rear,N);

	struct LL *main_head = appendList(root->data);

	struct LL *head = main_head;
	
	enQueue(queue,&rear,root);
	
	struct BT *temp;
	
	while(!isQueueEmpty(&front,&rear) && head)
	{
		temp = deQueue(queue,&front);
		
		if(temp->left)
		{
			head->next = appendList(temp->left->data);
			
			head = head->next;

			enQueue(queue,&rear,temp->left);
		}
		if(temp->right)
		{
			head->next = appendList(temp->right->data);
			
			head = head->next;

			enQueue(queue,&rear,temp->right);
		}
	}
	return main_head;
}

int sizeOfTree(struct BT *root)
{
	return root ? 1 + sizeOfTree(root->left) + sizeOfTree(root->right) : 0;
}

void printList(struct LL *head)
{
	for( ; head; head=head->next)
		printf(" %d,",head->data);
}
void main()
{
	struct BT *root = newNode(10);
	root->left = newNode(12);
	root->right = newNode(15);
	root->left->left = newNode(25);
	root->left->right = newNode(30);
	root->right->left = newNode(36);

	printList(createLL(root, sizeOfTree(root)));
}
