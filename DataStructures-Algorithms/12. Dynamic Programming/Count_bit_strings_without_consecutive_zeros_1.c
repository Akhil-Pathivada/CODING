/*
Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 0’s.

(Brute-Force approach)

Time Complexity : O((2^n)*n)
Space Complexity : O(n)
*/

#include<stdio.h>

int checkConsecutive( int *arr,int n)
{
	for(int i=1; i<n; ++i)
	{	
		if(!arr[i] && !arr[i-1])
			return 0;
	}
	
	return 1;	
}

void getAllBitStrings( int *arr, int i, int N, int *count)
{
	if(i==N)
	{
		*count += checkConsecutive(arr,i);
			
		return;
	}

	arr[i] = 0;
	
	getAllBitStrings(arr,i+1,N,count);
	
	arr[i] = 1;
	
	getAllBitStrings(arr,i+1,N,count);
}

void main()
{
	int N = 4;
	
	int count=0, arr[N];
	
	getAllBitStrings(arr,0,N,&count);
	
	printf(" Bit Strings without consecutive 0's : %d ", count);
}
