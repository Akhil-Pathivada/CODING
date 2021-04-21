/*
Given an array of n integers where each value represents number of chocolates in a packet. Each packet can have variable number of chocolates. 
There are m students, the task is to distribute chocolate packets such that:

	1.Each student gets one packet.
	2.The difference between the number of chocolates in packet with maximum chocolates and packet with minimum chocolates given to the 
	  students is minimum.
	
Time Complexity : O(n*logn)
Space Complexity : O(1)	
*/

#include<stdio.h>
#include<stdlib.h>
#include<limits.h>

int compareTo(const void *a, const void *b)
{
	return (*(int*)a - *(int*)b);
}

int getMinDifference( int *arr, int m, int n)
{	
	if(m > n)
		return -1;

	qsort(arr, n, sizeof(*arr) ,compareTo);
	
	int minDiff = INT_MAX;
	
	for(int i=0; i < n-m+1; ++i)
	{
		int diff = arr[i+m-1] - arr[i];
		
		if(diff < minDiff)
			minDiff = diff;
	}
	
	return minDiff;
}

void main()
{
	int arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50}; 
	
	int size = sizeof(arr)/sizeof(*arr);
	
	int m = 7;
	
	printf("Min. difference = %d ", getMinDifference(arr,m,size));
}
