/*
Program to find the Kth node from the end of the Linked List

Time Complexity :: O(n)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
	int data;
	struct node *next;
}Node;
Node *head,*rear,*nn;
void Insert(Node *nn)
{
	if(!head) 
		head=rear=nn;
	else
	{
		rear->next=nn;
		rear=nn;
	}
}
void Display(Node *cur)
{
	printf("\n-----------------------------------------------\n LINKED LIST ::");
	for( ;cur; printf(" %d->",cur->data),cur=cur->next);
	printf("\n-----------------------------------------------\n");
}
Node* findNode(Node *head,int K)
{
	if(K<=0 || !head)
		return NULL;
		
	Node *p, *q;
	
	p = q = head;
	
	for(int count=1; count<K && p; ++count)
		p = p->next;
	
	if(!p) 
		return 0;
		 
	while(p->next)
	{
		 q = q->next;
		 
		 p = p->next
	}
	
	return q;
}
int main()
{
	int n,ch,K;
	do
	{
		printf("\n\t1.INSERT");
		printf("\n\t2.DISPLAY");
		printf("\n\t3.Find the Kth node");
		printf("\n\nEnter U R Choice :: ");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:
				nn=(Node*)malloc(sizeof(Node));
				printf("\nEnter Node to insert :: ");
				scanf("%d",&nn->data);
				nn->next=NULL;
				Insert(nn);
				break;
			case 2:
				Display(head);
				break;
			case 3:
				printf("\nEnter K :: ");
				scanf("%d",&K);
				Node *Knode=findNode(head,K);
				printf("\n** Kth node from the end :: %d **\n",Knode->data);
				break;
		}
	}
	while(ch<4);
}
