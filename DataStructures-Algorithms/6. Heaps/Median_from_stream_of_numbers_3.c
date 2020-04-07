/*
Get the median from a stream of numbers (running integers)

Given that integers are read from a data stream. Find median of elements read so for in efficient way.
For simplicity assume there are no duplicates. For example, let us consider the stream 5, 15, 1, 3....


Time Complexity  : O(N*logN)
Space Complexity : O(N)
*/

#include<stdio.h>
#include<stdlib.h>
#include<limits.h>

void Swap(int *aptr,int *bptr)
{
	int temp = *aptr;
	*aptr = *bptr;
	*bptr = temp;
}

int extractRoot( int Heap[], int *size)
{
	int root = Heap[0];
	
	Heap[0] = Heap[--*size];	

	return root;
}

void MinHeapify(int minHeap[],int size,int i) // O(logN)
{
	int smallest = i;

	int left = (2*i)+1;
	int right = (2*i)+2;

	if(left<size && minHeap[left] < minHeap[smallest])
		smallest = left;

	if(right<size && minHeap[right] < minHeap[smallest])
		smallest = right;

	if(smallest != i)
	{
		Swap(&minHeap[i], &minHeap[smallest]);
		
		MinHeapify(minHeap, size, smallest);
	}
}

void MaxHeapify(int maxHeap[],int size,int i) // O(logN)
{
	int largest=i;

	int left=(2*i)+1;
	int right=(2*i)+2;

	if(left<size && maxHeap[left] > maxHeap[i])
		largest=left;

	if(right<size && maxHeap[right] > maxHeap[largest])
		largest=right;

	if(largest!=i)
	{
		Swap(&maxHeap[i],&maxHeap[largest]);
		MaxHeapify(maxHeap,size,largest);
	}
}

void insertMinHeap( int minHeap[], int *size, int key) // O(logN)
{
	int i=*size;
	
	minHeap[i]=key;	

	while(i>=0 && minHeap[(i-1)/2] > minHeap[i])
	{
		Swap(&minHeap[i],&minHeap[(i-1)/2]);
		i=--i/2;
	}
	
	++*size;	
}

void insertMaxHeap( int maxHeap[], int *size, int key) // O(logN)
{
	int i=*size;
	
	maxHeap[i]=key;	
	
	while(i>=0 && maxHeap[(i-1)/2] < maxHeap[i])
	{
		Swap(&maxHeap[i],&maxHeap[(i-1)/2]);
		i=--i/2;
	}
	
	++*size;
}

void checkBalance( int minHeap[], int maxHeap[], int *minHeapSize, int *maxHeapSize)
{
	int diff = (*maxHeapSize)-(*minHeapSize);
	
	if(diff > 1)
	{
		int root = extractRoot(maxHeap,maxHeapSize);
		
		MaxHeapify(maxHeap,*maxHeapSize,0);
		
		insertMinHeap(minHeap,minHeapSize,root);
	}
	else if(diff < -1)
	{
		int root = extractRoot(minHeap,minHeapSize);

		MinHeapify(minHeap,*minHeapSize,0);
		
		insertMaxHeap(maxHeap,maxHeapSize,root);
	}	
}

void insertElement( int minHeap[], int maxHeap[], int *minHeapSize, int *maxHeapSize, int key)
{
	if(key < maxHeap[0])
		insertMaxHeap(maxHeap,maxHeapSize,key);

	else
		insertMinHeap(minHeap,minHeapSize,key);

	checkBalance(minHeap,maxHeap,minHeapSize,maxHeapSize);	
}

void printMedian( int minHeap[], int maxHeap[], int *minHeapSize, int *maxHeapSize, int index)
{
	int diff = (*maxHeapSize)-(*minHeapSize);
	
	if(diff==0)
		printf(" Median at %d is : %d,%d \n",index, *maxHeap, *minHeap);

	else if(diff==1)
		printf(" Median at %d is : %d \n",index, *maxHeap);
		
	else
		printf(" Median at %d is : %d \n",index, *minHeap);
}

void getMedian( int *arr, int n)
{
	int minHeap[n], maxHeap[n];

	int minHeapSize = 0, maxHeapSize = 1;
	
	maxHeap[0] = *arr;
	
	for(int i=1; i<n ;++i)
	{
		insertElement(minHeap,maxHeap,&minHeapSize,&maxHeapSize,arr[i]);
		
		printMedian(minHeap,maxHeap,&minHeapSize,&maxHeapSize,i);
	}
}

void main()
{
	int arr[] = {21,10,15,3,4,14,32,45,11,12,16}; // running integers
	
	int size = sizeof(arr)/sizeof(*arr);
	
	getMedian(arr,size);
}
