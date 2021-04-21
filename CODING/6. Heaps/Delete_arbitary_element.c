/* 
Delete an Arbitary element from Min Heap

Time Complexity : O(n)+O(logn)
Space Complexity : O(1)
*/

#include<stdio.h>

void Swap(int *p,int *q)
{
	int temp=*p;
	*p=*q;
	*q=temp;
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

int searchElement(int Heap[],int size,int target)
{
	for(int i=0;i<size;i++)
	{
		if(Heap[i]==target)
			return i;	
	}
	return -1;
}

void main()
{
	int MinHeap[]={1,2,3,6,5,4,7,8,9,12,10};
	int size=sizeof(MinHeap)/sizeof(*MinHeap);
	int target=2;
	
	int index=searchElement(MinHeap,size,target);
	if(index==-1)
		return;
		
	MinHeap[index]=MinHeap[--size];
	MinHeapify(MinHeap,size,index);
	
	for(int i=0;i<size;i++)
		printf(" %d,",i[MinHeap]);
}
