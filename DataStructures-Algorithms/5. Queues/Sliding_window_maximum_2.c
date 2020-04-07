/*
Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.

Time Complexity : O(n)
Space Complexity : O(k)
*/

#include<stdio.h>
#include<stdbool.h>

int peekFirst( int *deque, int *arr, int first)
{
	return arr[deque[first]];
}

int peekLast( int *deque, int *arr, int rear)
{
	return arr[deque[rear]];
}

bool isQueueEmpty(int rear)
{
	return rear == -1;
}

void removeLast(int *front, int *rear)
{
	--*rear;
	
	if(*rear == -1)
		*front = 0;
}

void removeFirst(int *front)
{
	++*front;
}

void addLast( int *deque, int *rear, int index)
{
	deque[++*rear] = index;
}

void printMax( int *arr, int n, int k)
{
	int i, front, rear, deque[k];
	
	front = 0;
	
	rear = -1;
	
	for(i=0; i<k; ++i)
	{
		while(!isQueueEmpty(rear) && arr[i] >= peekLast(deque,arr,rear))
			removeLast(&front, &rear);
		
		addLast(deque, &rear, i);
	}
	
	for( ; i<n; ++i)
	{
		printf(" %d", peekFirst(deque, arr, front));
		
		while(!isQueueEmpty(rear) && deque[front] <= i-k)
			removeFirst(&front);
		
		while(!isQueueEmpty(rear) && arr[i] >= peekLast(deque,arr,rear))
			removeLast(&front, &rear);
		
		addLast(deque, &rear, i);
	}
	
	printf(" %d", peekFirst(deque, arr, front));
}

void main()
{
	int arr[] = {8, 6, 10, 7, 5, 17, 14, 87, 15};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	int k = 3;
	
	printMax(arr,n,k);
}
