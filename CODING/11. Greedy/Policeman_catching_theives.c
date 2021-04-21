/*
Given an array of size n that has the following specifications:

  1.Each element in the array contains either a policeman or a thief.
  2.Each policeman can catch only one thief.
  3.A policeman cannot catch a thief who is more than K units away from the policeman.
  
Time Complexity : O(n)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdlib.h>

struct node
{
	int index;
	struct node *next;
};

void insertNode( struct node **head,int index)
{
	struct node *nn= (struct node*)malloc(sizeof(struct node));
	
	nn->index=index;
	nn->next=NULL;
	
	if( !(*head))
	{
		(*head)=nn;
		return;
	}
	
	nn->next= *head;
	*head=nn;
}

int catchTheives( char arr[], int K, int n)
{
	struct node *police=NULL;
	struct node *theives=NULL;
	
	int count=0;
	
	for(int i=n-1; i>=0; --i)
	
		(arr[i]=='P') ?	insertNode(&police,i) : insertNode(&theives,i);
	
	while( police && theives)
	{
		int p=police->index;
		int t=theives->index;
		
		if(abs(p-t) <= K)
		{
			++count;
			police=police->next;
			theives=theives->next;
		}
		
		else if(p>t)
			theives=theives->next;
			
		else	
			police=police->next;
	}
	
	return count;
}

void main()
{
	char arr[]={'P','T','T','T','P','T','P','P','P'};

	int n= sizeof(arr)/sizeof(*arr);
	
	int K=2;

	printf(" Theives can be caught : %d ",catchTheives(arr,K,n));
}
