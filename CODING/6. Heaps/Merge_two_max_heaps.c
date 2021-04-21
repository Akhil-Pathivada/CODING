/*
Given two binary max heaps as arrays, merge the given heaps.

Time Complexity : O(m+n)
Space Complexity : O(log m+n)
*/
#include<stdio.h>

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

void buildToMaxHeap(int heap[], int size)
{
	for(int i=(size/2)-1 ; i>=0; --i)
		MaxHeapify(heap,size,i);
}

void mergeMaxHeaps( int *a, int *b, int *merged, int m, int n)
{	
	for(int i=0; i<m; ++i)
		merged[i] = a[i];
	
	for(int i=0 ; i<n; ++i)
		merged[i+m] = b[i];
		
	buildToMaxHeap(merged, m+n);
}

void main()
{
	int a[] = {10, 5, 6, 2};
	
	int b[] = {12, 7, 9};
	
	int m = sizeof(a)/sizeof(*a);
	
	int n = sizeof(b)/sizeof(*b);
	
	int merged[m+n];
	
	mergeMaxHeaps(a, b, merged, m, n);
	
	for(int i=0; i<m+n; ++i)
		printf(" %d", merged[i]);
}
