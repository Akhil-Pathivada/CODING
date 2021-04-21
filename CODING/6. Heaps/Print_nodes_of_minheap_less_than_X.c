/*
Given a binary min heap and a value x, print all the binary heap nodes having value less than the given value x.

Time Complexity : O(n)
Space Complexity : O(log n)
*/

#include<stdio.h>

int left(int i)
{
	return 2 * i + 1;
}

int right(int i)
{	
	return 2 * i + 2;
}

void printLesserThan( int *heap, int index, int n, int x)
{
	if(index >= n)
		return;
	
	if(heap[index] >= x)
		return;
	
	printf("%d ", heap[index]);
	
	printLesserThan(heap, left(index), n, x);
	
	printLesserThan(heap, right(index), n, x);
}

void main()
{
	int minHeap[] = {2, 3, 15, 5, 4, 45, 80, 6, 150, 77, 120};
	
	int n = sizeof(minHeap)/sizeof(*minHeap);
	
	int x = 100;
	
	printLesserThan(minHeap, 0, n, x);
		
}
