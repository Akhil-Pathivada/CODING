/* Program to Insert a key in the Max Heap

Time Complexity : O(logn)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<limits.h>

void Swap(int *p,int *q)
{
	int temp = *p;
	*p = *q;
	*q = temp;
}

void IncreaseKey(int heap[],int i,int key)
{
	if(key < heap[i])
		printf("Error");

	heap[i] = key;

	while(i>=0 && heap[(i-1)/2]<heap[i])
	{
		Swap(&heap[i],&heap[(i-1)/2]);
		
		i = --i/2;
	}
}


void InsertKey( int heap[], int *size, int key)
{
	
	heap[*size] = INT_MIN;	

	IncreaseKey(heap,*size,key);

	++*size;	
}

int main()
{
	int heap[] = {9,8,7,4,5,6,3,2,1};
	
	int size = sizeof(heap)/sizeof(int);

	printf(" Initial Heap : ");
	
	for(int i=0; i<size; ++i)
		printf(" %d",heap[i]);
	
	int key = 100;

	InsertKey(heap,&size,key);
	
	printf("\n Result Heap :: ");
	
	for(int i=0; i<size; ++i)
		printf(" %d",heap[i]);
	
}
