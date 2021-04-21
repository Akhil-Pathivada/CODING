/*
Program to get the vertical sum of the Binary Tree.....
Time Complexity :: O(n)
Space Complexity :: O(n)+O(n)......(Recursion + DLL)

*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

struct node
{
	int data;
	struct node *left,*right;
};

struct DLL
{
	int data;
	struct DLL *prev, *link, *next;
};

void makeLink(struct DLL *node1, struct DLL *node2) //O(1)
{
	struct DLL *temp1 = node1->prev;
	
	struct DLL *temp2 = node1->next;
	
	temp1->next = node2;
	temp2->prev = node2;

	node2->prev = temp1;
	node2->next = temp2;
	node2->link = node1;
}

struct node *newNode(int val)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->left = nn->right = NULL;
	
	return nn;
}

void getMinMax(struct node *root,struct DLL *head) //O(n)
{
	if(root)
	{
		head->data = root->data;
		
		struct DLL *leftNode, *rightNode;
		
		if(root->left)
		{
			leftNode = (struct DLL*)malloc(sizeof(struct DLL));
			
			struct DLL *temp = head->prev;
			
			head->prev = leftNode;
			
			leftNode->next = head;
			
			if(temp)
				makeLink(temp,leftNode);
		}
		
		if(root->right)
		{
			rightNode = (struct DLL*)malloc(sizeof(struct DLL));
			
			struct DLL *temp = head->next;
			
			head->next = rightNode;
			
			rightNode->prev = head;
			
			if(temp)
				makeLink(temp,rightNode);
		}
		
		getMinMax(root->left,leftNode);
		
		getMinMax(root->right,rightNode);
	}
}
void printVerticalOrder(struct DLL *head) // printing the DLL Table...... O(n)
{
	for( ; head; head=head->next)
	{
		int sum=0;
		
		struct DLL *curr=head
		
		for( ;curr; curr=curr->link)
			sum += curr->data;
			
		printf(" %d,",sum);
	}
}

int sizeOfTree(struct node *root)
{
	return root? 1 + sizeOfTree(root->left) + sizeOfTree(root->right) : 0;
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
	
	struct DLL *head = (struct DLL*)malloc(sizeof(struct DLL));
	
	getMinMax(root,head);
	
	for( ;head->prev;head=head->prev); // traversing to the Head Node
	
	printVerticalOrder(head);
}
