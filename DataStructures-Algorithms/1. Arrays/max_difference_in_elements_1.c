/*
Find the maximum difference between two elements such that larger element appears after the smaller element

Time Complexity : O(n^2)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<limits.h>

void findMaxDifference(int arr[],int N)
{
	int smallIndex, largeIndex, max = INT_MIN;

	for(int i=0; i<N-1; i++)
	{
		for(int j=i+1; j<N; j++)
		{
			int diff = arr[j] - arr[i];

			if(diff>max)
			{
				max = diff;
				smallIndex = i;
				largeIndex = j;
			}
		}
	}

	printf(" Max.Difference between %d and %d is : %d \n", arr[smallIndex], arr[largeIndex], max);
}

int main()
{
	int arr[] = {101,2,7,6,10,1,13,100};

	findMaxDifference(arr,8);
}
