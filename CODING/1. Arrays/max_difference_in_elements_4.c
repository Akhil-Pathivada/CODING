/*
Find the maximum difference between two elements such that larger element appears after the smaller element

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>

int Max(int a,int b)
{
	return a>b ? a : b;
}

int findMaxDifference(int arr[],int N)
{
	int currDiff, prevDiff, maxDiff;

	prevDiff = maxDiff = arr[1]-arr[0];

	for(int i=1; i<N-1; ++i)
	{
		currDiff = arr[i+1]-arr[i];

		if(prevDiff>0)
			currDiff += prevDiff;

		maxDiff = Max(maxDiff,currDiff);

		prevDiff = currDiff;
	}

	return maxDiff;
}

int main()
{
	int arr[]={3,6,1,7,5,100,10};

	printf(" Max.Difference is : %d ", findMaxDifference(arr,7));
}
