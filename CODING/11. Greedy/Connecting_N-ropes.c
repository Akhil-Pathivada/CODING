/*
There are given n ropes of different lengths, we need to connect these ropes into one rope.
The cost to connect two ropes is equal to sum of their lengths. We need to connect the ropes with minimum cost.

Time Complexity : O(N*logN)
Space Complexity : O(logN)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

void Swap( int *aptr, int *bptr)
{
	int temp= *aptr;
	*aptr=*bptr;
	*bptr=temp;
}

void MinHeapify( int ropes[], int size, int index) 
{
	int smallest=index;

	int left = (2*index)+1;
	int right = (2*index)+2;

	if(left<size &&  ropes[left] < ropes[smallest])
		smallest = left;

	if(right<size &&  ropes[right] < ropes[smallest])
		smallest = right;

	if(smallest != index)
	{
		Swap (&ropes[index], &ropes[smallest]);
		
		MinHeapify (ropes,size,smallest);
	}
}
void insertMinHeap( int ropes[], int cost, int *size)
{
	ropes[*size] = cost; 	

	for(int i=*size; i>=0 && ropes[(i-1)/2] > ropes[i] ; i=--i/2)
		
		Swap( &ropes[i], &ropes[(i-1)/2]);	
		
	++*size;
}

int ExtractMin( int ropes[], int *size)
{	
	int min = ropes[0];

	ropes[0] = ropes[--*size];

	MinHeapify (ropes,*size,0);
	
	return min;
}

void convertToMinHeap( int ropes[], int size)
{
	for(int i=(size/2)-1 ; i>=0; --i)
		MinHeapify(ropes, size, i);
}

int connectRopes( int ropes[], int size)
{		
	convertToMinHeap(ropes,size);
	
	int minCount=0;
	
	while(size>1)
	{
		int cost = ExtractMin(ropes, &size) + ExtractMin(ropes, &size);
		
		insertMinHeap( ropes,cost,&size);
		
		minCount += cost;
	}
	
	return minCount;
}

void main()
{
	int ropes[] = {7,3,2,5,13,9};
	
	int size = sizeof(ropes)/sizeof(*ropes);
	
	printf(" Min. Cost to connect Ropes : %d ",connectRopes(ropes,size));
}
