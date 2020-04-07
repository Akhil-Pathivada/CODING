/*
Find the maximum difference between two elements such that larger element appears after the smaller element

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<limits.h>

int Max(int a,int b)
{
	return a > b ? a : b;
}

int findMaxDifference(int arr[],int N)
{
	int diffArr[N], maxDiff = INT_MIN;

	for(int i=0; i<N-1; ++i)
		diffArr[i] = arr[i+1]-arr[i];

	for(int i=1; i<N; ++i)
	{
		if(diffArr[i-1] > 0)
			diffArr[i] += diffArr[i-1];

		maxDiff = Max(maxDiff,diffArr[i]);
	}

	return maxDiff;
}

int main()
{
	int arr[] = {3,1,4,7,5,100,10};

	printf(" Max.Difference is : %d ", findMaxDifference(arr,7));
}
