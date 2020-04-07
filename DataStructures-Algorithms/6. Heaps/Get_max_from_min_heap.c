/*
Get the max. element from the Min Heap

Time Complexity : O(n)
Space Complexity :O(1)
*/

#include<stdio.h>
#include<limits.h>

void main()
{
	int MinHeap[]={1,2,3,6,5,4,7,8,9,7,8};
	int size=sizeof(MinHeap)/sizeof(*MinHeap);
	
	int max=INT_MIN;

	for(int i=size/2;i<size;i++)
		max=(MinHeap[i]>max)?MinHeap[i]:max;

	printf(" Max. element : %d \n",max);
}
