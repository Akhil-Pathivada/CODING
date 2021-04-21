// Understanding the behaviour of 'Generic Pointer'

#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *next;
};

struct node *newNode(int val)
{
	struct node *nn=(struct node*)malloc(sizeof(struct node));
	nn->data=val;
	nn->next=NULL;
	return nn;
}

void main()
{
	void *gp;
	struct node *ptr=newNode(21);
	
	gp=ptr;
	
	printf(" ptr : %p \n",ptr);
	printf(" gp : %p \n\n",gp);
	
	printf(" ptr->data : %d \n",ptr->data);
	printf(" gp->data : %d \n",((struct node*)gp)->data);
}
