
/*
The C library function 

void qsort(void *base, size_t nitems, size_t size, int (*compar)(const void *, const void*)) 

sorts an array.*/

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
	
	printf(" After Sorting : ");
	for(int i=0;i<size;i++)
		printf(" %d,",i[arr]);
}
