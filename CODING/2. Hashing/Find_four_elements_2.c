/*
Find four elements i,j,k,l in an array such that i+j = k+l

(Using BST)

Time Complexity : O(n^2 * logN)
Space Complexity : O(n^2)
*/

#include<stdio.h>
#include<stdlib.h>

struct LL
{
	int x,y;
	struct LL *next;
};

struct BT
{
	int sum,count;
	struct LL *link;
	struct BT *left,*right;
};

struct LL *newListNode( int d1, int d2)
{
	struct LL *nn = (struct LL*)malloc(sizeof(struct LL));
	
	nn->x = d1;
	
	nn->y = d2;
	
	nn->next = NULL;
	
	return nn;
}


struct BT *newTreeNode(int data)
{
	struct BT *nn = (struct BT *)malloc(sizeof(struct BT));
	
	nn->sum = data;
	
	nn->count = 0;
	
	nn->left = nn->right = NULL;
	
	return nn;
}

struct BT *searchTree(struct BT *root, int target) // O(logN)
{
	
	while(root)
	{
		if(root->sum == target)
			return root;
			
		else if(root->sum > target)
			root = root->left;
		
		else
			root = root->right;
	}
	return NULL;
}

void addTree( struct BT **root, struct BT *nn) // O(logN)
{
	if(!*root)	
	{
		*root = nn;
		
		return;
	}
		
	struct BT *parent, *curr = *root;
	
	while(curr)
	{
		parent = curr;
		
		if(nn->sum > curr->sum)
			curr = curr->right;
		else
			curr = curr->left;
	}
	
	if(nn->sum < parent->sum)
		parent->left = nn;
	else	
		parent->right = nn;
}

void addList(struct BT *treeNode, struct LL *listNode) // O(1)
{
	struct LL *temp = treeNode->link;
	
	treeNode->link = listNode;
	
	listNode->next = temp;
	
	treeNode->count ++;
}

void printElements(struct BT *root)
{
	if(!root)
		return;
	
	if(root->count > 1)
	{
	
		struct LL *head = root->link;
	
		for( ; head; head=head->next)
			printf("%d,%d,",head->x,head->y);
	
		printf("\n");
	}

	printElements(root->left);
	
	printElements(root->right);
}

void getElements( int *arr, int n)
{
	struct BT *root = NULL;
	
	for(int i=0; i<n; ++i)
	{
		for(int j=i+1; j<n; ++j)
		{
			struct BT *treeNode = NULL;
			
			struct LL *listNode = NULL;
			
			int sum = arr[i] + arr[j];
			
			listNode = newListNode(arr[i],arr[j]);
			
			if(treeNode = searchTree(root,sum))
				addList(treeNode,listNode);
				
			else
			{
				treeNode = newTreeNode(sum);

				addTree(&root, treeNode);
				
				addList(treeNode,listNode);
			}	
		}
	}
	
	printElements(root);
}

void main()
{
	int arr[] = {6,2,3,4,5};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	getElements(arr,size);
}
