/*
Given an array arr[] of N integers. 
The task is to replace all the elements of the array by the absolute difference of the smallest element on its left and the largest element on its right.

Time Complexity : O(n)
Space Complexity : O(n)
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
	int i,minSoFar, tempArr[n], maxArr[n];	
	
	maxArr[n-1] = 0;
	
	// Computing the Max.Array for every element
	for(i=n-2; i>=0; --i)
		maxArr[i] = maxArr[i+1] > arr[i+1] ? maxArr[i+1] : arr[i+1];

	minSoFar = arr[0];
	
	tempArr[0] = maxArr[0];
	
	for(i=1; i<n; ++i)
	{
		tempArr[i] = abs(maxArr[i] - minSoFar);
		
		minSoFar = arr[i]<minSoFar ? arr[i] : minSoFar;
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
