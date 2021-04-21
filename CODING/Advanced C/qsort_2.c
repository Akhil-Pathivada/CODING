/*
The C library function 

void qsort(void *base, size_t nitems, size_t size, int (*compar)(const void *, const void*)) 

sorts an array (Descending Order).*/

#include<stdio.h>
#include<stdlib.h>

int compareTo(const void *a,const void *b)
{
	return ( *(int*)b - *(int*)a );
}

void main()
{
	int arr[] = {1,2,3,4,5,6};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	qsort(arr, size, sizeof(*arr), compareTo);
	
	printf(" After Sorting : ");
	
	for(int i=0; i<size; ++i)
		printf(" %d", i[arr]);
}
