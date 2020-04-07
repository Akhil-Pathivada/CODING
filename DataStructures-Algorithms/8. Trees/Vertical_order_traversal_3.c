/* Program to get the vertical order of the Binary Tree.....

Here,we are using a DLL instead of HashTable..,which can grow dynamically

Time Complexity : O(n)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

struct node
{
	int data;
	struct node *left;
	struct node *link;
	struct node *right;
};

struct node *newNode(int val)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->left = nn->right = nn->link = NULL;

	return nn;
}

void createPrevNode(struct node *root, struct node *head)
{
	struct node *nn = newNode(root->data);

	if(head->left)
	{
		struct node *temp = head->left->link;
		
		head->left->link = nn;
		
		nn->link = temp;

		return;
	}

	head->left = nn;
	
	nn->right = head;
}

void createNextNode(struct node *root,struct node *head)
{
	struct node *nn = newNode(root->data);

	if(head->right)
	{
		struct node *temp = head->right->link;
		
		head->right->link = nn;
		
		nn->link = temp;

		return;
	}

	head->right = nn;
	
	nn->left = head;
}

void getVerticalOrder(struct node *root,struct node *head) //O(n)
{
	if(root->left)
	{
		createPrevNode(root->left, head);
		
		getVerticalOrder(root->left, head->left);
	}

	if(root->right)
	{
		createNextNode(root->right, head);
		
		getVerticalOrder(root->right, head->right);
	}
}

void printVerticalOrder(struct node *root) 
{
	struct node *head = newNode(root->data);
	
	getVerticalOrder(root,head);
	
	for( ; head->left; head=head->left); 
	
	for( ; head; head=head->right)
	{
		struct node *curr = head;

		for( ; curr; curr=curr->link)
			printf(" %d,",curr->data);
	}
}

int sizeOfTree(struct node *root)
{
	return root ? 1 + sizeOfTree(root->left) + sizeOfTree(root->right) : 0;
}

void main()
{
	struct node *root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->left->left->left = newNode(1);
	root->left->left->right = newNode(3);
	root->left->left->right->left = newNode(39);
	root->left->left->right->right = newNode(19);
	root->left->right = newNode(50);
	root->right->left = newNode(60);
	root->right->left->left = newNode(45);
	root->right->right = newNode(70);
	root->right->right->left = newNode(65);
	root->right->right->left->left = newNode(95);
	root->right->right->left->right = newNode(99);
	root->right->right->right = newNode(100);
	
	printVerticalOrder(root);
}
