/*
Count number of SubArrays possible with sum Zero.....

Time Complexity : O(n^2)
Space Complexity : O(n)
*/
#include<stdio.h>

int countSubArrays(int arr[], int N)
{
	int sumArr[N] , count=0;

	*sumArr = arr[0];

	for(int i=1; i<N; i++)
		sumArr[i] = arr[i] + sumArr[i-1];

	for(int i=0; i<N; i++)
	{
		for(int j=i+1; j<N; j++)
		{
			if(sumArr[j] == sumArr[i])
				count++;
		}
	}

	return count;
}

void main()
{
	int arr[] = {11,10,-5,-3,-2,10,7,-1,-6};
	
	printf(" Total SubArrays : %d ",countSubArrays(arr,9));
}
