/*
An array contains both positive and negative numbers in random order. Rearrange the array elements so that positive and negative numbers are
placed alternatively. Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end 
of the array. If there are more negative numbers, they too appear in the end of the array.

Time Complexity : O(n)
Space Complexity : O(1)
*/
#include<stdio.h>

void Swap( int *a, int *b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

void reArrange( int arr[], int n)
{
	int i = -1;
		
	for(int j=0 ; j<n; ++j)
	{
		if(arr[j] < 0)
			Swap(&arr[++i], &arr[j]);
	}
		
	int pos = i+1;
		
	int neg = 0;
		
	while(pos < n && neg < pos && arr[neg] < 0)
	{
		Swap(&arr[neg], &arr[pos]);
			
		++pos;
			
		neg += 2;
	}
}

void main()
{
	int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		
	int n = sizeof(arr)/sizeof(*arr);
		
	reArrange(arr, n);
		
	for(int i=0; i<n; ++i)
		printf("%d ", arr[i]);
}
