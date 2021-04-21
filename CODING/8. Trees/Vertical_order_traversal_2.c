/* 
Program to get the vertical order of the Binary Tree.....

Time Complexity :: O(n)
Space Complexity :: O(n)+O(n)......(Recursion + HashTable)
*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

struct node
{
	int data;
	struct node *left,*right;
};

struct HASH
{
	int key;
	struct HASH *next;
}**hash_table;

struct node *newNode(int val)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->left = nn->right = NULL;

	return nn;
}

void insertHash(int key,int index) // O(1)
{
	struct HASH *nn = (struct HASH*)malloc(sizeof(struct HASH));

	nn->key = key;
	
	nn->next = hash_table[index];
	
	hash_table[index] = nn;	
}

void getMinMax(struct node *root, int *MIN, int *MAX, int count) //O(n)
{
	if(!root)
		return;

	*MIN = (count< *MIN) ? count : *MIN;

	*MAX = (count> *MAX) ? count : *MAX;

	getMinMax(root->left, MIN, MAX, count-1);

	getMinMax(root->right, MIN, MAX, count+1);

	int index = abs(*MIN) + count;

	insertHash(root->data,index);
}

void printVerticalOrder(int range) // printing the Hash Table...... O(n)
{
	for(int i=0; i<=range; ++i)
	{
		struct HASH *curr;

		for( curr=hash_table[i]; curr; curr=curr->next)
			printf(" %d,",curr->key);
	}
}

int sizeOfTree(struct node *root)
{
	return root ? 1 + sizeOfTree(root->left) + sizeOfTree(root->right) : 0;
}

void main()
{
	int MIN = 0, MAX = 0;
	
	struct node *root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->left->left->left = newNode(1);
	root->left->left->right = newNode(3);
	root->left->left->right->left = newNode(39);
	root->left->right = newNode(50);
	root->right->left = newNode(60);
	root->right->left->left = newNode(45);
	root->right->right = newNode(70);
	root->right->right->left = newNode(65);
	root->right->right->right = newNode(90);

	hash_table = (struct HASH**)malloc(sizeof(struct HASH*)*sizeOfTree(root));

	//getting the values of MIN,MAX
	getMinMax(root, &MIN, &MAX, 0); 

	printVerticalOrder(MAX - MIN);
}
