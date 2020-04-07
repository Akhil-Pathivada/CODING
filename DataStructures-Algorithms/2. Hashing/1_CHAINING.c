/*
 Program for Insertion,Search,Deletion in Hash Table(Chaining)......
 Search Time :: O(1)

*/

#include<stdio.h>
#include<stdlib.h>
#define MAX 6

typedef struct node 
{
	int data;
	struct node *next;
}Node;

Node *hash_table[MAX]; // declaring Array of Pointers

int H(int x)
{
	return x % MAX;
}

void Insert(int val)
{
	int x = H(val);

	Node *newnode = (Node*)malloc(sizeof(Node));
	newnode->data = val;

	newnode->next = hash_table[x];
	hash_table[x] = newnode;
}

int Search(int val)
{
	Node *ptr = hash_table[H(val)];

	for( ; ptr && ptr->data != val ; ptr=ptr->next);	
	
	return ptr ? 1 : 0;
}

void Delete(int val)
{
	Node *ptr = hash_table[H(val)];

	for( ; ptr && ptr->data != val ; ptr=ptr->next);
	
	Node *temp = ptr->next ? ptr->next : ptr;

	if(ptr->next)		
	{
		ptr->data=ptr->next->data;
		ptr->next=ptr->next->next;
	}

	free(temp);
}

void main()
{
	int val,ch;
	do
	{
		printf("\n\t1.Insert ");
		printf("\n\t2.Search");
		printf("\n\t3.Delete");
		
		printf("\n Enter U R Choice : ");
		scanf("%d",&ch);
		
		switch(ch)
		{
			case 1 :
				printf("\nEnter the Elements :: ");
				for(int i=0;i<MAX;i++)
				{
					scanf("%d",&val);
					Insert(val);
				}
				break;
			case 2:
				printf("\nEnter the element to Search :: ");
				scanf("%d",&val);
				Search(val)?printf("\n** Element was found **\n"):printf("\n** Element was not found **\n");
				break;	
			case 3:
				printf("\n Enter the element to delete :: ");
				scanf("%d",&val);
				Search(val)?Delete(val):printf("\n** Element was not present **\n");
				break;
		}
	}while(ch<4);
}
