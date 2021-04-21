/*
Given a Binary tree and a key in the binary tree, find the node right to the given key. If there is no node on right side, then return NULL.

Time Complexity : O(n)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

struct node {

	int data;
	struct node *left, *right;
};

struct node *newNode(int val) {

	struct node *nn = (struct node*)malloc(sizeof(struct node));
	nn->data = val;
	nn->left = nn->right = NULL;

	return nn;
}

struct node **createQueue(int *front, int *rear, int N) {

	struct node **queue = (struct node**)calloc(N,sizeof(struct node*));
	*front = *rear = 0;

	return queue;
}

void enQueue(struct node **queue, struct node *root, int *rear) {

	queue[(*rear)++] = root;
}

struct node* deQueue(struct node **queue, int *front) {

	return queue[(*front)++];
}

bool isQueueEmpty(int *front, int *rear) {

	return ((*front) == (*rear));
}

int sizeOfQueue(int *front, int *rear) {

	return ((*rear) - (*front));
}

struct node* getNextRight(struct node *root, struct node *targetNode, int N) {

	int front, rear;
	struct node **queue = createQueue(&front, &rear, N);

	enQueue(queue, root, &rear);

	while(!isQueueEmpty(&front, &rear)) {

		int size = sizeOfQueue(&front, &rear);

		while(size--) {

			struct node *temp = deQueue(queue, &front);

			if(temp == targetNode) {

				if(size)
					return deQueue(queue, &front);
				return NULL;
			}
			if(temp->left)
				enQueue(queue, temp->left, &rear);

			if(temp->right)
				enQueue(queue, temp->right, &rear);
		}
	}
	return NULL;
}

struct node *getNode(struct node *root, int target) {

	if(!root)
		return NULL;

	if(root->data == target)
		return root;

	struct node *flag = getNode(root->left, target);

	if(!flag)
		getNode(root->right, target);

}

int sizeOfTree(struct node *root) {

	return root ? (1 + sizeOfTree(root->left) + sizeOfTree(root->right)) : 0;
}

int main() {

	struct node *root = newNode(2);
	root->left = newNode(7);
	root->right = newNode(5);
	root->left->left = newNode(8);
	root->left->right = newNode(6);
	root->right->right = newNode(9);	
	root->left->right->left = newNode(1);
	root->left->right->right = newNode(11);
	root->right->right->left = newNode(4);
	root->right->right->right = newNode(10);	

	int N = sizeOfTree(root);

	struct node *targetNode = getNode(root, 6);

	if(targetNode && (targetNode = getNextRight(root, targetNode, N)))
		printf(" Right Node : %d ", targetNode->data);
	else
		printf(" NULL ");
}
