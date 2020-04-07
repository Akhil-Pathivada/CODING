/*
Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number. 

Time Complexity : O(n^2)
Space Complexity : O(1)
*/
#include<stdio.h>
void findSubArray(int arr[],int N,int target)
{
	int startIndex,lastIndex;
	
	for(int i=0;i<N;i++)
	{
		int sum = 0;
		
		for(int j=i;j<N;j++)
		{
			sum += arr[j];
			
			if(sum > target)
				break;
				
			if(sum == target)
			{
				printf(" Sum found between %d and %d ", i, j);
				
				return;
			}
		}
	}
	printf(" No SubArray found\n");
}

int main()
{
	int arr[]={1,4,0,0,3,10,5};
	findSubArray(arr,7,7);
}
