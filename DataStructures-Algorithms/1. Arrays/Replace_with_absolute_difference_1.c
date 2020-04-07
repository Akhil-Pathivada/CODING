/*
Given an array arr[] of N integers. 
The task is to replace all the elements of the array by the absolute difference of the smallest element on its left and the largest element on its right.

Time Complexity : O(n^2)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

int getMin( int *arr, int n)
{
	if(n==0)
		return 0;
	
	int min = arr[0];
	
	for(int i=1; i<=n; ++i)
		min = arr[i]<min ? arr[i] : min;
		
	return min;
}

int getMax( int *arr, int i, int n)
{
	if(i == n-1)
		return 0;
	
	int max = arr[++i];
	
	for( ; i<n; ++i)
		max = arr[i]>max ? arr[i] : max;
		
	return max;
}


void generateArr( int *arr, int n)
{	
	int i,min,max, tempArr[n];	
	
	for(i=0; i<n; ++i)
	{
		min = getMin(arr,i);
		
		max = getMax(arr,i,n);
		
		tempArr[i] = abs(min-max);
	}
	
	// printing the temp Array	
	for(int i=0; i<n; ++i)
		printf(" %d,",tempArr[i]); 
}

void main()
{
	int arr[] = { 1, 5, 2, 4, 3 }; 
	
	int n = sizeof(arr) / sizeof(arr[0]);
	
	generateArr(arr,n);
}
