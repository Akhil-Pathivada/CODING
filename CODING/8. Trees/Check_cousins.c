/*
Check two nodes are cousins or not in Binary Tree....

Time Complexity :: O(n)
Space Complexity ::O(n)
*/ 
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node
{
	int data;
	struct node *left,*right;
};

struct node* newNode(int val)
{
    struct node* nn = (struct node*)malloc(sizeof(struct node));
   
    nn->data = val;
   
    nn->left = nn->right = NULL;
   
    return nn;
}

int checkSiblings(struct node *root,struct node *n1,struct node *n2) // O(n)
{

	if(!root)
		return 0;
	
	return ((root->left==n1 && root->right==n2)||(root->left==n2 && root->right==n1)) || 
		  checkSiblings(root->left,n1,n2) ||
		  checkSiblings(root->right,n1,n2);
}

void getNodes(struct node *root,struct node **n1,struct node **n2,int a,int b) // O(n)
{
	if(!root)
		return;
		
	if(root->data == a)
		*n1 = root;
		
	if(root->data == b)
		*n2 = root;
		
	getNodes(root->left, n1, n2, a, b);
	
	getNodes(root->right, n1, n2, a, b);
}
int getLevel(struct node *root,struct node *node,int level) // O(n)
{
	if(!root)
		return -1;
		
	if(root == node)
		return level;
		
	int flag = getLevel(root->left,node,level+1);
	
	if(flag!= -1)
		return flag;
	
	return getLevel(root->right,node,level+1);
}

bool checkCousins(struct node *root,struct node *n1,struct node *n2)
{
	return (getLevel(root,n1,1)==getLevel(root,n2,1)) && (!checkSiblings(root,n1,n2));
}

void main()
{
    int a, b;
    
    struct node *n1 = NULL,*n2 = NULL;
    
    struct node* root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->right->left = newNode(5);
    root->right->right = newNode(6);
    root->left->right = newNode(7);
    
    printf("Enter two nodes :: ");
    
    scanf("%d%d",&a,&b);
    
    getNodes(root,&n1,&n2,a,b);
  
    printf(checkCousins(root,n1,n2) ? "Yes" : "No");
}
