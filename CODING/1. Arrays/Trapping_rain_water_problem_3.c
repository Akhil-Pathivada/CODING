/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>

int min( int a, int b)
{
	return a<b ? a : b;
}

int max( int a, int b)
{
	return a>b ? a : b;
}

int findMaxWater( int *arr, int n)
{
	int leftMax, rightMax, low, high, water=0;
	
	leftMax = rightMax = 0;
	
	low =0 ;
	
	high = n-1;
	
	while(low <= high)
	{
		if(arr[low] < arr[high])
		{
			if(arr[low] > leftMax)
				leftMax = arr[low];
		
			else
				water += leftMax - arr[low];
			
			low++;
		}
		else
		{
			if(arr[high] > rightMax)
				rightMax = arr[high];
			
			else
				water += rightMax - arr[high];
				
			high--;
		}
		 
	}
		
	return water;
}

void main()
{
	int arr[] = {1, 0, 2, 0, 1, 0, 3, 1, 0, 2};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	printf(" Max. water that can be holded = %d ",findMaxWater(arr,n));
}
