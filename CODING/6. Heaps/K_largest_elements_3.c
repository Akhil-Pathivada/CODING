/*
Given an array and a number k where k is smaller than size of array, we need to find the k largest elements in the given array. 
It is given that all array elements are distinct.

Time Complexity : O(k + (n-k)*Logk)
Space Complexity : O(1)
*/

#include<stdio.h>

void Swap(int *aptr,int *bptr)
{
	int temp=*aptr;
	*aptr=*bptr;
	*bptr=temp;
}

void MinHeapify(int heap[],int size,int index) 
{
	int smallest=index;

	int left=(2*index)+1;
	int right=(2*index)+2;

	if(left<size && heap[left]<heap[smallest])
		smallest=left;

	if(right<size && heap[right]<heap[smallest])
		smallest=right;

	if(smallest!=index)
	{
		Swap(&heap[index],&heap[smallest]);
		MinHeapify(heap,size,smallest);
	}
}

void ConvertToMinHeap(int heap[],int size) // O(K)
{
	for(int i=(size/2)-1 ;i>=0;i--)
		MinHeapify(heap,size,i);
}
 
int kLargestElements(int *heap,int K,int N) 
{
	ConvertToMinHeap(heap,K);
	
	for(int i=K;i<N;++i)
	{
		if(heap[i] > *heap)
		{
			*heap=heap[i];
			MinHeapify(heap,K,0);
		}
	}
}

void printElements(int arr[],int N)
{
	for(int i=0;i<N;++i)
		printf(" %d,",arr[i]);
}

void main(void)
{
	int arr[]={1,3,23,9,21,6,-23};
	int N=sizeof(arr)/sizeof(*arr);

	int K=4;
	int max=kLargestElements(arr,K,N);
	printElements(arr,K);
}

/*

K largest Elements : 6, 9, 23, 21, (print in Ascending Order)

*/
