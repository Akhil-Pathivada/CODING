/*
Program to print the Level Order of the Binary Tree

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>

struct node {

	int data;
	struct node *left,*right;
};

struct node* newNode(int val) {

	struct node *temp = (struct node*)malloc(sizeof(struct node));
	temp->data = val;
	temp->left = temp->right = NULL;

	return temp;
}

struct node** createQueue( int *front, int *rear, int N) {

	struct node **queue = (struct node**)malloc(sizeof(struct node*)*N);
	*front = *rear = 0;
	return queue;
}

void enQueue(struct node **queue, int *rear, struct node *newnode) {

	queue[(*rear)++] = newnode;
}

struct node* deQueue(struct node **queue,int *front) {

	return queue[(*front)++];
}

int isQueueEmpty(int *front,int *rear) {

	return ((*front) == (*rear));
}

void getLevelOrder(struct node *root, int N) {

	int front,rear;

	struct node **queue = createQueue(&front,&rear,N);
	struct node *temp;

	enQueue(queue,&rear,root);

	while(!isQueueEmpty(&front,&rear)) {

		temp = deQueue(queue,&front);
		printf(" %d,",temp->data);

		if(temp->left)
			enQueue(queue,&rear,temp->left);

		if(temp->right)
			enQueue(queue,&rear,temp->right);
	}
}

int sizeOfTree(struct node *root) {

	return root ? (1+sizeOfTree(root->left)+sizeOfTree(root->right)) : 0;
}

int main() {

	struct node *root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->left->right = newNode(50);
	root->right->left = newNode(60);
	root->right->right = newNode(70);	
	
	int N = sizeOfTree(root);

	getLevelOrder(root,N);
}
