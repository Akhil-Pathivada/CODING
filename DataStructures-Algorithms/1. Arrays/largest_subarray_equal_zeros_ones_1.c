/*
Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s.

Time Complexity : O(n^3)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

void findLargestSubArray(int arr[],int N)
{
	int startIndex,lastIndex,max=-1;

	for(int i=0;i<N-1;i++)
	{
		for(int j=i;j<N;j++)
		{
			int zeroCount=0,oneCount=0,length;
			for(int k=i;k<=j;k++)
				arr[k] ? ++oneCount : ++zeroCount;

			length=(zeroCount==oneCount) ? j-i+1 :-1;

			if(length>max)
			{
				startIndex=i;
				lastIndex=j;
				max=length;
			}
		}
	}

	if(max==-1)
		printf(" No such SubArray \n");
	else
		printf(" Largest Sub Array from %d to %d \n",startIndex,lastIndex);
}

int main()
{
	int arr[]={1,0,1,1,0,1,1};
	findLargestSubArray(arr,7);
}
