/*
The C library function 

void *bsearch(const void *key, const void *base, size_t nitems, size_t size, int (*compar)(const void *, const void *)) 

function implements Binary Search
*/

#include<stdio.h>
#include<stdlib.h>

int compareTo(const void *a,const void *b)
{
	return ( *(int*)a - *(int*)b );
}

void main()
{
	int arr[] = {6,5,4,3,2,1};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	qsort(arr, size, sizeof(*arr), compareTo);
	
	int key = 2;
	
	int *flag = bsearch(&key, arr, size, sizeof(*arr), compareTo);
	
	if(flag)
		printf(" Found item: %d ",*flag);
	else
		printf(" Not found ");
}
