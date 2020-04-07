/*
Given an array arr of size N and a number K. 
The task is to find the minimum elements to be replaced in the array with any number such that the array consists of K distinct elements.

Time Complexity : O(N*logN)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
#define MAX 1000

int compareTo(const void *a, const void *b)
{
	return ( *(int*)b - *(int*)a);
} 

int countElements( int *arr, int k, int n)
{
	qsort(arr,n,sizeof(*arr),compareTo);	
	
	int freq[MAX] = {0};
	
	int p = 0;
	
	freq[p] = 1;
	
	for(int i=1; i<n; ++i)
	{
		if(arr[i] == arr[i-1])
			++freq[p];
		else
			++freq[++p]; 
	}
		
	qsort(freq,p,sizeof(*freq),compareTo);
	
	int res = 0;
	
	for(int i=k; i<=p; ++i)
		res += freq[i];
	
	return res;
}

void main()
{
	int arr[] = { 1, 2, 7, 8, 2, 3, 2, 3 }; 
      
    	int n = sizeof(arr) / sizeof(arr[0]); 
      
   	int k = 2;
   	
   	printf(" Min. elements to get replaced = %d ", countElements(arr,k,n));
}
