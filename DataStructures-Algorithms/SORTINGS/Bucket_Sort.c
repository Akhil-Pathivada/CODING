/*
Sort a large set of floating point numbers which are in range from 0.0 to 1.0 and are uniformly distributed across the range. 

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
#define SIZE 10

struct node
{
	float data;
	struct node *next;
};

struct node* newNode(float data)
{
	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->next = NULL;
	
	return nn;
}

void Insert( struct node **HashTable, int index, float key)
{
	struct node *ptr = HashTable[index];
	
	struct node *nn = newNode(key);
	
	if(!ptr)
		HashTable[index] = nn;

	else if(key <= ptr->data)
	{
		nn->next = HashTable[index];
		
		HashTable[index] = nn;
	}
	else
	{
		while(ptr->next && ptr->data < key)
			ptr = ptr->next;
	
		struct node *temp = ptr->next;
	
		ptr->next = nn;
	
		nn->next = temp;
	}
}

void BucketSort( float *arr, int n)
{
	struct node **HashTable = (struct node**)malloc(sizeof(struct node*)*SIZE);
	
	int i, bi;
	
	i = bi = 0;
	
	for(i=0; i<n; ++i)
	{
		bi = SIZE * arr[i];
		
		Insert(HashTable, bi, arr[i]);
	}
	
	i = bi = 0;
	
	// copying result to array
	for(bi=0; bi<SIZE; ++bi)
	{
		struct node *ptr = HashTable[bi];
		
		while(ptr)
		{
			arr[i++] = ptr->data;
			
			ptr = ptr->next;
		}
	}	
}

void main()
{
	float arr[] = {0.897, 0.9565, 0.656, 0.12134, 0.120365, 0.3434, 0.4123, 0.567, 0.756, 0.1136};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	BucketSort(arr, n);
	
	// printing the sorted array
	for(int i=0; i<n; ++i)
		printf(" %f", arr[i]);
}
