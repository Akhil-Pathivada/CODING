/*
LRU Cache Implementation....

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#define size 3
#include<stdbool.h>

void moveRight(int *queue, int last)
{
	for(int i=last; i>0; --i)
		queue[i] = queue[i-1];
}

bool isCacheFree( int rear)
{
	return rear != size ;
}

int isCacheHit( int *cache, int page)
{
	for(int i=0; i<size; ++i)
	{	
		if(cache[i] == page)
			return i;
	}
	return -1;	
}

void replacePage( int *cache, int oldPage, int newPage)
{
	for(int i=0; i<size; ++i)
	{
		if(cache[i] == oldPage)
		{
			cache[i] = newPage;
			
			return;
		}
	}
}

void replaceLRU( int *cache, int *ref, int n)
{
	int queue[size];
	
	int rear = 0;
	
	for(int i=0; i<n; ++i)
	{	
		int newPage = ref[i];
		
		int index;
		
		if((index = isCacheHit(cache, newPage)) != -1)
			moveRight(queue, index);
		
		else if(isCacheFree(rear))
		{
			cache[rear++] = newPage;
			
			moveRight(queue, size-1);
		}
			
		else
		{
			int victim = queue[size-1];
			
			moveRight(queue, size-1);
			
			replacePage(cache, victim, newPage);
		}
		
		queue[0] = newPage;
	}
}

void main()
{
	int cache[size] = {0};
	
	int ref[] = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3};
	
	int n = sizeof(ref)/sizeof(*ref);
	
	replaceLRU(cache, ref, n);
	
	printf(" Resultant Cache : ");
	
	for(int i=0; i<size; ++i)
			printf(" %d,",cache[i]);
}
