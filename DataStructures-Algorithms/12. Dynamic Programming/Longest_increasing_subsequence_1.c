/*
Find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. 
For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.

(Naive Approach)

*/

#include<stdio.h>

int LIS( int *arr, int n, int *maxLen)
{
	if(n==1)
		return 1;
		
	int res, max_ending_here = 1;
	
	for(int i=1; i<n; ++i)
	{
		res = LIS(arr, i, maxLen);
		
		if(arr[i-1] < arr[n-1]  &&  res+1 > max_ending_here)
			max_ending_here = res+1;
	} 
	
	if(max_ending_here > *maxLen)
		*maxLen = max_ending_here;
		
	return max_ending_here;
}

int getLIS( int arr[], int n)
{
	int max = 1;
	
	LIS(arr, n, &max);
	
	return max;
}

void main()
{	
	int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
	
	int n = sizeof(arr)/sizeof(*arr);
	
	printf(" Longest Increasing Subsequence : %d ", getLIS(arr,n));
}
