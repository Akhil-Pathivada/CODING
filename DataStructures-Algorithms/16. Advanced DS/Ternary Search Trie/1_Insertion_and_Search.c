/*
Insertion and Search in Ternary Search Trie....

Time Complexity : Height of Tree
Space Complexity : Length of String 
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node
{
	char data;
	struct node *left, *eq, *right;
	bool isEnd;
};

struct node *newNode( char ch)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));

	nn->data = ch;

	nn->isEnd = false;

	nn->left = nn->eq = nn->right = NULL;

	return nn;
}

void Insert( struct node **root, char *word)
{
	if(!*root)
		*root = newNode(*word);

	if(*word < (*root)->data)
		Insert( &(*root)->left, word);

	else if(*word > (*root)->data)
		Insert( &(*root)->right, word);

	else
	{
		if(*(word+1))
			Insert( &(*root)->eq, word+1);

		else
			(*root)->isEnd = true;
	}
}

bool searchTST( struct node *root, char *word)
{
	if(!root)
		return false;

	if(*word < root->data)
		return searchTST( root->left, word);

	else if(*word > root->data)
		return searchTST( root->right, word);

	else
	{
		if(!*(word+1))
			return root->isEnd;

		return searchTST(root->eq, word+1);
	}
}

int main()
{
	struct node *root = NULL;

	Insert( &root, "cat");
	Insert( &root, "cats");
	Insert( &root, "up");
	Insert( &root, "akhil");
	Insert( &root, "mahesh");

	printf( searchTST(root, "cats") ? " String Found " : " String not Found ");

	printf( searchTST(root, "akhii") ? " String Found " : " String not Found ");

	return 0;
}