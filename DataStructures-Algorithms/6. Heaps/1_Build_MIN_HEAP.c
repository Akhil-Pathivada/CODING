/*
Program to build the MIN HEAP

Time Complexity : O(n)
Space Complexity : O(logn)
*/

#include<stdio.h>
#include<stdlib.h>

void Swap(int *aptr,int *bptr)
{
	int temp = *aptr;
	*aptr = *bptr;
	*bptr = temp;
}

void MinHeapify(int heap[],int size,int index) 
{
	int smallest = index;

	int left = (2*index)+1;
	
	int right = (2*index)+2;

	if(left<size && heap[left]<heap[smallest])
		smallest = left;

	if(right<size && heap[right]<heap[smallest])
		smallest = right;

	if(smallest != index)
	{
		Swap(&heap[index],&heap[smallest]);
		
		MinHeapify(heap,size,smallest);
	}
}

void convertToMinHeap(int heap[],int size)
{
	for(int i=(size/2)-1 ; i>=0; --i)
		MinHeapify(heap,size,i);
}

int main()
{
	int heap[] = {1, 3, 2, 4, 7, 10, 6, 5, 11, 9, 8, 14, 12};

	printf(" Initial Array : ");
	
	for(int i=0; i<9;i++)
		printf(" %d", heap[i]);

	convertToMinHeap(heap, 9);

	printf("\n Result Heap : ");
	
	for(int i=0; i<9; ++i)
		printf(" %d",heap[i]);	
}
