/*
Given an array and a number k, where k is smaller than size of array, we need to find the k’th largest element in the given array. 
It is given that all array elements are distinct.

Time Complexity : O(n)+O(k*logn) ---> O(n)
Space Complexity : O(1)
*/
#include<stdio.h>

void Swap(int *aptr,int *bptr)
{
	int temp = *aptr;
	*aptr = *bptr;
	*bptr = temp;
}

void MaxHeapify(int heap[],int size,int i) 
{
	int largest = i;

	int left = (2*i)+1;
	int right = (2*i)+2;

	if(left<size && heap[left]>heap[i])
		largest = left;

	if(right<size && heap[right]>heap[largest])
		largest = right;

	if(largest!=i)
	{
		Swap(&heap[i],&heap[largest]);
		
		MaxHeapify(heap,size,largest);
	}
}

void ConvertToMaxHeap(int heap[],int size) // O(n)
{
	for(int i=(size/2)-1 ; i>=0 ; --i)
		MaxHeapify(heap,size,i);
}

int ExtractMax(int heap[], int *size) // O(1)
{
	if(*size<1)
		printf("UNDERFLOW");
		
	int max = heap[0];

	heap[0] = heap[(*size)-1];

	--*size;

	return max;
}
 
int KthLargestElement(int *arr,int K,int N) // O(K*logN)
{
	ConvertToMaxHeap(arr,N);
	
	for(int i=1; i<K; ++i) // (K-1) times 
	{
		ExtractMax(arr,&N);
		
		MaxHeapify(arr,N,0);	
	}

	return ExtractMax(arr,&N);
}

void main(void)
{
	int arr[] = {1, 3, 23, 9, 21, 6, -23};
	
	int N = sizeof(arr)/sizeof(*arr);

	int max = KthLargestElement(arr,4,N);

	printf("Kth largest element = %d ",max);
}
