/*
Given a Binary Tree, write a function to check whether the given Binary Tree is Complete Binary Tree or not.
A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node {

	int data;
	struct node *left,*right;
};

struct node *newNode(int data) {

	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	nn->left = nn->right = NULL;
	
	return nn;
}

struct node **createQueue(int *front, int *rear, int N) {

	struct node **queue = (struct node **)malloc(sizeof(struct node*) * N);
	
	*front = *rear = 0;
	
	return queue;
}

void enQueue(struct node **queue, int *rear, struct node *nn) {

	queue[(*rear)++] = nn;
}

struct node *deQueue(struct node **queue, int *front) {

	return queue[(*front)++];
}

bool isQueueEmpty(int front, int rear) {

	return front == rear;
}

bool checkCompleteBT(struct node *root, int N) {

	if(!root) {
		return true;
	}
		
	int front, rear;	
	
	struct node **queue = createQueue(&front, &rear, N);
	bool flag = false;

	enQueue(queue, &rear, root);
	
	while(!isQueueEmpty(front, rear)) {

		struct node *temp = deQueue(queue, &front);
		
		if(temp->left) {

			if(flag) {
				return false;
			}
				
			enQueue(queue, &rear, temp->left);
		}
		else {
			flag = true;
		}
		
		if(temp->right) {

			if(flag) {
				return false;
			}
			
			enQueue(queue, &rear, temp->right);
		}
		else {
			flag = true;
		}
	}		
	return true;
}

int getSize(struct node *root) {

	return root ? 1 + getSize(root->left) + getSize(root->right) : 0;
}

int main() {
	
	struct node *root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->left->right = newNode(50);
	root->right->left = newNode(60);
	root->right->right = newNode(70);	
	root->left->left->left = newNode(80);
	//root->left->right->right = newNode(90);
	
	int n = getSize(root);
	
	printf(checkCompleteBT(root, n) ? " YES " : " NO ");
}
