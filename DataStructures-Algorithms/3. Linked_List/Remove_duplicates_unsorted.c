/* 
Remove duplicate nodes from a Unsorted linked list

Time Complexity :: O(n)
Space Complexity :: O(n)
*/

#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *next;
};

struct node* newNode(int val)
{
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->next=NULL;
	return nn;
};

int *hash_table;

int H(int x,int MAX) // O(1).....Linear Probing
{
	int index,k=x%MAX;
	if((!(hash_table[k])) || (hash_table[k]==x))
		return k;
	for(index=(k+1)%MAX ; hash_table[index]&&index!=k ; index=(++index)%MAX)
	{
		if(hash_table[index]==x)
			return index;
	}
	return !(hash_table[index])?index:0;
}

struct node* removeDuplicateNodes(struct node *curr,int n) //O(n)
{
	struct node *main_head,*ptr;
	main_head=curr;
	ptr=NULL;
	for( ;curr;curr=curr->next)
	{
		int temp=curr->data;
		int x=H(curr->data,n);
		if(hash_table[x]!=temp)
		{
			hash_table[x]=temp;
			if(ptr)
				ptr->next=curr;
			ptr=curr;
		}
	}
	ptr->next=NULL;
	return main_head;
}

void printList(struct node *head)
{
	for( ;head;head=head->next)
		printf(" %d->",head->data);
	printf("\n");
}

int getSize(struct node *curr) // O(n)
{
	return curr?(1+getSize(curr->next)):0;
}

void main()
{
	struct node *head=newNode(4);
	head->next=newNode(3);
	head->next->next=newNode(3);
	head->next->next->next=newNode(1);
	head->next->next->next->next=newNode(1);
	head->next->next->next->next->next=newNode(4);
	head->next->next->next->next->next->next=newNode(2);
	head->next->next->next->next->next->next->next=newNode(3);
	head->next->next->next->next->next->next->next->next=newNode(2);

	printList(head);
	int n=getSize(head);

	hash_table=(int*)malloc(sizeof(int)*n);
	removeDuplicateNodes(head,n); 

	printList(head);
}
