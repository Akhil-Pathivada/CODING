// Count the nodes,full nodes,leaves,non-leaves,height of the tree......

#include<stdio.h>
#include<stdlib.h>

struct node 
{
	int data;
	struct node *left,*right;
};

struct node* newNode(int val)
{
	struct node *temp = (struct node*)malloc(sizeof(struct node));
	
	temp->data = val;
	
	temp->left = temp->right = NULL;
	
	return temp;
}

int countNodes(struct node *t)
{
	return t ? 1+countNodes(t->left)+countNodes(t->right) : 0;
}

int countFullNodes(struct node *t)
{
	if(!t) 
		return 0;

	if(!t->left && !t->right)  
		 return 0;

	return countFullNodes(t->left) + countFullNodes(t->right) + ((t->left && t->right)?1:0);
}

int countLeaves(struct node *t)
{
	if(t)
	    return (!t->left && !t->right) ? 1 : countLeaves(t->left) + countLeaves(t->right);
}

int count_NonLeaves(struct node *t)
{
	if(t)
	    return (t->left||t->right) ? 1 + count_NonLeaves(t->left) + count_NonLeaves(t->right) : 0;
}

int getHeight(struct node *t)
{
	if(!t) 
		return 0;

	if(!t->left && !t->right) 
		return 0;

	return 1 + (getHeight(t->left) > getHeight(t->right) ? getHeight(t->left) : getHeight(t->right));
}

void main()
{
	struct node *root = newNode(10);
	root->left = newNode(20);
	root->right = newNode(30);
	root->left->left = newNode(40);
	root->left->right = newNode(50);
	root->right->left = newNode(60);
	root->right->right = newNode(70);	
	
	int ch;

	do
	{
		printf("\n\t1.Get total Nodes");
		printf("\n\t2.Get Full_Nodes");
		printf("\n\t3.Get Leaves");
		printf("\n\t4.Get Non_Leaves");
		printf("\n\t5.Height of the tree");

		printf("\n Enter U R Choice :: ");
		scanf("%d",&ch);

		switch(ch)
		{
			case 1:
				printf("\n** No. of nodes in the tree : %d **",countNodes(root));
				break;
			case 2:
				printf("\n** No. of full nodes in the tree : %d **",countFullNodes(root));
				break;
			case 3:
				printf("\n** No. of leaves in the tree : %d **",countLeaves(root));
				break;
			case 4:
				printf("\n** No. of non-leaves in the tree : %d **",count_NonLeaves(root));
				break;
			case 5:
				printf("\n** Height of the tree : %d **",getHeight(root));
				break;
		}
	}while(ch<6);
}
