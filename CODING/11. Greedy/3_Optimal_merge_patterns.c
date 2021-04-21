/*
Program for Optimal Merge Patterns......

Given n number of sorted files, the task is to find the minimum computations done to reach Optimal Merge Pattern. 

Time Complexity : O(N*logN)
Space Complexity : O(1)

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

void MinHeapify( int files[], int size, int index) 
{
	int smallest=index;

	int left=(2*index)+1;
	int right=(2*index)+2;

	if(left<size &&  files[left] < files[smallest])
		smallest=left;

	if(right<size &&  files[right] < files[smallest])
		smallest=right;

	if(smallest!=index)
	{
		Swap ( &files[index], &files[smallest]);
		
		MinHeapify (files,size,smallest);
	}
}

void insertMinHeap( int files[], int mergeCount, int *size)
{
	files[*size]= mergeCount; 	

	for(int i=*size; i>=0 && files[(i-1)/2] > files[i] ; i=--i/2)
		
		Swap( &files[i], &files[(i-1)/2]);	
		
	++*size;
}

int ExtractMin( int files[], int *size)
{	
	int min = files[0];

	files[0] = files[--*size];

	MinHeapify (files,*size,0);
	
	return min;
}

void convertToMinHeap( int files[], int size)
{
	for(int i=(size/2)-1 ;i>=0; --i)
		MinHeapify( files,size,i);
}

int mergeFiles( int files[], int size)
{		
	convertToMinHeap(files,size);

	int mergeCount=0;
	
	while(size>1)
	{
		int count = ExtractMin(files, &size) + ExtractMin(files, &size);
		
		insertMinHeap( files,count,&size);
		
		mergeCount += count;
	}
	
	return mergeCount;
}

void main()
{ 
 	int files[] = { 40, 10, 20, 15, 25, 30}; 
 	
 	int size= sizeof(files)/sizeof(*files);
 	
 	printf(" Min. Computations : %d ", mergeFiles(files,size)); 	
}
