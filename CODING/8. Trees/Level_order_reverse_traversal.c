/*
Program to get the Level Order of a tree in Reverse fashion.....

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

struct node* newNode(int val)
{
	struct node *temp = (struct node*)malloc(sizeof(struct node));
	
	temp->data = val;
	
	temp->left = temp->right = NULL;

	return temp;
}

struct node** createQueue( int *front, int *rear, int N)
{
	struct node **queue = (struct node**)malloc(sizeof(struct node*)*N);

	*front = *rear = 0;

	return queue;
}
struct node** createStack( int *top, int N)
{
	struct node **stack = (struct node**)malloc(sizeof(struct node*)*N);

	*top = -1;

	return stack;
}

void enQueue(struct node **queue,int *rear,struct node *newnode)
{
	queue[(*rear)++] = newnode;
}

struct node* deQueue(struct node **queue,int *front)
{
	return queue[(*front)++];
}

void Push( struct node **stack, struct node *root, int *top)
{
	stack[++*top] = root;
}

struct node* Pop(struct node **stack, int *top)
{
	return stack[(*top)--];
}

bool isQueueEmpty(int *front,int *rear)
{
	return (*front)==(*rear);
}

bool isStackEmpty(int *top)
{
	return *top == -1;
}

void getReverseLevelOrder( struct node *root, int N)
{
	int front, rear, top;
	
	struct node **Queue = createQueue( &front, &rear, N);
	
	struct node **Stack = createStack( &top, N);
	
	struct node *temp;
	
	enQueue(Queue, &rear, root);
	
	while(!isQueueEmpty(&front, &rear))
	{
		temp = deQueue(Queue,&front);
		
		Push(Stack, temp, &top);
		
		if(temp->left)
			enQueue(Queue, &rear, temp->left);
			
		if(temp->right)
			enQueue(Queue, &rear, temp->right);
	}
	
	while(!isStackEmpty(&top))
		printf(" %d ," ,Pop(Stack, &top)->data);
}

int sizeOfTree(struct node *root)
{
	return root ? 1 + sizeOfTree(root->left)+sizeOfTree(root->right) : 0;
}

int main()
{
	struct node *root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->left->right = newNode(50);
	root->right->left = newNode(60);
	root->right->right = newNode(70);	

	int N = sizeOfTree(root);

	getReverseLevelOrder(root,N);
}
