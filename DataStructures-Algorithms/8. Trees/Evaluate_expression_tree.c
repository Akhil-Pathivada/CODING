/*
Evaluation of Expression Tree

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
struct node
{
	char *str;
	struct node *left,*right;
};

struct node* newNode(char *val)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->str = val;
	
	nn->left = nn->right = NULL;

	return nn;
}

int evaluateTree(struct node *root)
{
	if(!root)
		return 0;

	int a = evaluateTree(root->left);
	
	int b = evaluateTree(root->right);
	
	char *ch = root->str;

	switch(*ch)
	{
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		case '/':
			return a/b;
	}
	return atoi(ch);
}

int main()
{
	struct node *root = newNode("+");
	root->left = newNode("*");
	root->right = newNode("-");
	root->left->left = newNode("5");
	root->left->right = newNode("4");
	root->right->left = newNode("100");
	root->right->right = newNode("/");
	root->right->right->left = newNode("20");
	root->right->right->right = newNode("2");

	printf(" Result = %d ",evaluateTree(root));
}
