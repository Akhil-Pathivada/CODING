//Deletion  in Binary Search Tree......

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node
{
	int data;
	struct node *left,*right;
};

void Insert(struct node **root,int val)
{
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->left=nn->right=NULL;
	
	if(!(*root))
	{
		*root=nn;
		return;
	}
	
	struct node *parent,*curr=*root;
	
	while(curr)
	{
		parent=curr;
		curr = val < curr->data ? curr->left : curr->right;
	}
	
	if(val < parent->data)
		parent->left=nn;
	else
		parent->right=nn;
}

void Preorder(struct node *root)
{
	if(!root)
		return;

	printf(" %d,",root->data);
	Preorder(root->left);
	Preorder(root->right);
}

struct node *searchNode( struct node *root, struct node **parent, int target)
{
	if(root->data==target) // check root
	{
		*parent=NULL;
		
		return root;
	}
	
	while(root && root->data!=target)
	{
		*parent=root;
		
		root = target < root->data ? root->left : root->right;
	}
		
	return root;
}

int deleteFullNode(struct node *root) // Inorder Predecessor
{
	struct node *parent=root;
	
	root=root->left;
	
	if(!root->right)
	{
		parent->left = root->left;
		
		return root->data;
	}
	
	for( ;root->right ;root=root->right)
		parent=root;
		
	parent->right = root->left;
	
	return root->data;
}

void deleteOneChildNode( struct node **root, struct node *parent, struct node *targetNode)
{
	if(!parent)
		(*root) = (*root)->left ? (*root)->left : (*root)->right ;
	
	else if(parent->left == targetNode)
		parent->left = targetNode->left ? targetNode->left : targetNode->right;

	else
		parent->right = targetNode->right ? targetNode->right : targetNode->left;
}

bool deleteNode( struct node **root, int target)
{
	struct node *parent;
	
	struct node *targetNode = searchNode(*root,&parent,target);
	
	if(!targetNode)
		return false;
	
	// deleting a FULL node
	if(targetNode->left && targetNode->right)	
		targetNode->data = deleteFullNode(targetNode);
	
	// deleting a Single Degree Node
	else if(!targetNode->left ^ !targetNode->right)	
		deleteOneChildNode(root,parent,targetNode);
		
	// deleting a LEAF node
	else		
	{
		if(parent->left == targetNode)
			parent->left=NULL;
		else
			parent->right=NULL;
	}

	return true;	
}

void main()
{
	struct node *root=NULL;
	
	int val,ch;
	
	do
	{
		printf("\n\t1.Insert ");
		printf("\n\t2.PREORDER");
		printf("\n\t3.Delete");
		
		printf("\nEnter U R Choice :: ");
		scanf("%d",&ch);
		
		switch(ch)
		{
			case 1:
				printf("\nEnter the value to insert :: ");
				scanf("%d",&val);
				Insert(&root,val);
				break;
				
			case 2:
				Preorder(root);
				break;
				
			case 3:
				printf("\nEnter the node to delete :: ");
				scanf("%d",&val);

				printf( deleteNode(&root,val) ? "** Successfully deleted ** \n" : "** Node was not found in the Tree ** \n");
				break;
		}
		
	}while(ch<5);
}
