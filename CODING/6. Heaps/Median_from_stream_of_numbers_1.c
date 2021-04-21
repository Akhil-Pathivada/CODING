/*
Get the median from a stream of numbers (running integers)

Given that integers are read from a data stream. Find median of elements read so for in efficient way.
For simplicity assume there are no duplicates. For example, let us consider the stream 5, 15, 1, 3....


Time Complexity  : O(n^2)
Space Complexity : O(1)
*/

#include<stdio.h>

int getMedian(int *arr,int n) // Insertion Sort
{
	int key;
	
	for(int i=1; i<=n; ++i)
	{
		key = arr[i];
		
		int j = i-1;
		
		while(j>=0 && arr[j]>key)
		{
			arr[j+1] = arr[j];
			--j;
		}

		arr[j+1]=key;
	}
	
	(n+1)&1 ? printf(" Median at %d is : %d \n",n,arr[n/2]) : printf(" Median at %d is : %d,%d \n",n,arr[n/2],arr[n/2+1]);
}

void printMedian(int *arr,int n)
{
	for(int i=0; i<n ;++i)
		getMedian(arr,i);
}

void main()
{
	int arr[]={21,10,15,3,4,14,32,45,11,12,16}; // running integers
	int size=sizeof(arr)/sizeof(*arr);
	
	printMedian(arr,size);
}
