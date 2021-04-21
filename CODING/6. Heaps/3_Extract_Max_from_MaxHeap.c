/* Program to extract the MAXIMUM from the Max Heap

Time Complexity : O(logn)
Space Complexity : O(logn)
*/
#include<stdio.h>
#include<stdlib.h>

void Swap(int *p,int *q)
{
	int temp = *p;
	*p = *q;
	*q = temp;
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

	if(largest != i)
	{
		Swap( &heap[i], &heap[largest]);
		
		MaxHeapify(heap, size, largest);
	}
}

int ExtractMax(int heap[],int *size)
{
	if(*size < 1)
		printf("UNDERFLOW");
		
	int max = heap[0];

	heap[0] = heap[(*size)-1];

	--*size;

	MaxHeapify(heap,*size,0);
	
	return max;
}
 
int main()
{
	int heap[] = {9,8,7,4,5,6,3,2,1};
	
	int size = sizeof(heap)/sizeof(int);
	
	printf(" Initial Heap : ");
	
	for(int i=0; i<size; ++i)
		printf(" %d",heap[i]);
		
	printf("\n Max. Element : %d \n",ExtractMax(heap,&size));

	printf("\n After Extraction : ");
	
	for(int i=0; i<size; ++i)
		printf(" %d",heap[i]);
}
