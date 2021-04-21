/* Program to Decrease a key in the Max Heap

Time Complexity : O(logn)
Space Complexity : O(logn)
*/
#include<stdio.h>

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

void DecreaseKey(int heap[], int size, int i, int key)
{
	if(key > heap[i])
		printf("Error");

	heap[i] = key;

	MaxHeapify(heap,size,i);
}

int main()
{
	int heap[] = {9,8,7,4,5,6,3,2,1};
	
	int size = sizeof(heap)/sizeof(int);
	
	printf(" Initial Heap : ");
	
	for(int i=0; i<size; ++i)
		printf(" %d",heap[i]);
	
	DecreaseKey(heap,size,1,-1);	

	printf("\n After Decrementation : ");
	
	for(int i=0; i<size; ++i)
		printf(" %d",heap[i]);

}
