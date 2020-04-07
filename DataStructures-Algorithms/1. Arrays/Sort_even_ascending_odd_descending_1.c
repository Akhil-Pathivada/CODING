/*
Given an array of integers (both odd and even), sort them in such a way that 
the first part of the array contains odd numbers sorted in descending order, rest portion contains even numbers sorted in ascending order.

Time Complexity : O(n*logn)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>

int compareOdd( const void *a, const void *b)
{
	return (*(int*)b - *(int*)a);
}

int compareEven( const void *a, const void *b)
{
	return (*(int*)a - *(int*)b);
}

void Swap( int *aptr, int *bptr)
{
	int temp = *aptr;
	
	*aptr = *bptr;
	
	*bptr = temp;
}

void twoWaySort( int *arr, int n)
{
	// partitioning into two parts
	int l = 0;
	
	int r = n-1;
	
	while(l<=r)
	{	
		if(!(arr[l]%2) && arr[r]%2)
		{
			Swap(&arr[l], &arr[r]);
			
			l++ ;
			
			r--;
		}
		
		else if(arr[l]%2)
			l++;
		
		else if(!(arr[r]%2))
			r--;
	}
	
	// Sorting both as seperately
	
	qsort(arr,l,sizeof(*arr),compareOdd);
	
	qsort(arr+l,n-l,sizeof(*arr),compareEven);
	
	// printing the array
	for(int i=0; i<n; ++i)
		printf(" %d,",arr[i]); 
}

void main()
{
	int arr[] = { 1, 3, 8, 2, 6, 5, 4 ,9, 10, 7};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	twoWaySort(arr,size);
}
