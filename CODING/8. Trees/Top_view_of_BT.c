/* Program to get the Top View   of the Binary Tree.....

Here,we are slightly modifying the code of Vertical Order Traversal..

Time Complexity :: O(n)
Space Complexity :: O(n)

*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

struct node {

	int data;
	struct node *left;
	struct node *link;
	struct node *right;
};

struct node *newNode(int val) {

	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->left = nn->right = nn->link = NULL;
	
	return nn;
}

void createPrevNode( struct node *root, struct node *head) {

	if(!head->left) {

		struct node *nn = newNode(root->data);
		
		head->left = nn;
		
		nn->right = head;
	}
}

void createNextNode( struct node *root,struct node *head) {

	if(!head->right) {

		struct node *nn = newNode(root->data);
		
		head->right = nn;
		
		nn->left = head;
	}
}

void getTopView( struct node *root, struct node *head) { //O(n)

	if(root->left) {

		createPrevNode(root->left,head);
		
		getTopView(root->left,head->left);
	}

	if(root->right) {

		createNextNode(root->right,head);
		
		getTopView(root->right,head->right);
	}
}

void printTopView(struct node *root) {

	struct node *head = newNode(root->data);
	
	getTopView(root,head);
	
	for( ; head->left; head=head->left); 
	
	for( ; head; head=head->right) {

	       	struct node *curr = head;

		for( ; curr; curr = curr->link)
			printf(" %d,",curr->data);
	}
}

int sizeOfTree(struct node *root) {

	return root ? 1 + sizeOfTree(root->left) + sizeOfTree(root->right) : 0;
}

int main() {

	struct node *root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->left->right = newNode(50);
	root->right->left = newNode(60);
	root->right->right = newNode(70);
	
	printTopView(root);
}
