/*
Given PreOrder & InOrder, create the BST

Time Complexity :: O(n)
Space Complexity :: O(n)+O(n).....(RECURSION + hash_table)
*/

#include<stdio.h>
#include<stdlib.h>
#define N 11

int start = 0;

struct node
{
	int data;
	struct node *left,*right;
};

struct
{
	int key,index;
}hash_table[N];

struct node *newNode(int val)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = val;
	
	nn->left = nn->right = NULL;

	return nn;
}

int H(int x) //O(1)
{
	int index, k=x%N;

	if(!hash_table[k].key)
		return k;

	for(index=(k+1)%N ; hash_table[index].key && index!=k ; index=(index+1)%N);

	return !hash_table[index].key ?index:0;
}

void insertHash(int index,int value) // O(1)
{
	int x=H(value);

	hash_table[x].key = value;
	
	hash_table[x].index = index+1;
}

int getPosition(int value) //O(1)
{
	int i,k=value%N;

	if(hash_table[k].key == value)
		return --hash_table[k].index;
		
	for(i=(k+1)%N ; hash_table[i].key!=value && i!=k  ; i=(++i)%N);

	return --hash_table[i].index;
}

void PostOrder(struct node *root)
{
	if(!root)
		return;
	
	PostOrder(root->left);
	
	PostOrder(root->right);

	printf(" %d,",root->data);
}

int getRoot(int *preorder,int min,int max) // O(1)
{
	return (min<=max) ? getPosition(preorder[start++]) : -1;
}

struct node *createTree(int *preorder,int *inorder,int MIN,int MAX) // O(n)
{
	int pos = getRoot(preorder,MIN,MAX);

	if(pos == -1)
		return NULL;

	struct node *root = newNode(inorder[pos]);

	root->left = createTree(preorder,inorder,MIN,pos-1);

	root->right = createTree(preorder,inorder,pos+1,MAX);

	return root;
}

void main()
{
	int preorder[N], inorder[N];

	printf(" enter PreOrder :");

	for(int i=0; i<N; i++)
		scanf("%d",&preorder[i]);

	printf(" enter InOrder : ");

	for(int i=0; i<N; i++)
		scanf("%d",&inorder[i]);

	// inserting 'inorder' into the Hash
	for(int i=0; i<N; i++)
		insertHash(i,inorder[i]);
		
	struct node *root = createTree(preorder,inorder,0,N-1);

	PostOrder(root);
}
