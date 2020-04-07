/*
Program to build the MAX HEAP

Time Complexity : O(n)
Space Complexity : O(logn)
*/

#include<stdio.h>
#include<stdlib.h>

void Swap(int *p,int *q)
{
	int temp=*p;
	*p=*q;
	*q=temp;
}

void MaxHeapify(int heap[],int size,int i) 
{
	int largest = i;

	int left = (2*i)+1;
	int right = (2*i)+2;

	if(left < size && heap[left] > heap[largest])
		largest = left;

	if(right < size && heap[right] > heap[largest])
		largest = right;

	if(largest != i)
	{
		Swap(&heap[i],&heap[largest]);
		
		MaxHeapify(heap,size,largest);
	}
}

void convertToMaxHeap(int heap[],int size)
{
	for(int i=(size/2)-1 ; i>=0; --i)
		MaxHeapify(heap,size,i);
}

int main()
{
	int heap[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

	printf(" Initial Array : ");
	
	for(int i=0; i<9; ++i)
		printf(" %d", heap[i]);

	convertToMaxHeap(heap, 9);

	printf("\n Result Heap : ");
	
	for(int i=0; i<9; ++i)
		printf(" %d",heap[i]);	
}
