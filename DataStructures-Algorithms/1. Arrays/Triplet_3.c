/*
 Find the Triplet whose sum is 'X'
 
Time Complexity : O(n^2)
Space Complexity : O(n)

Assume the Array was Unsorted
Solve through HASHING
*/

#include<stdio.h>
#include<stdlib.h>

int HASH[1000] = {0};

void FindTriplet(int *arr,int size,int X)
{
	printf("Triplets : ");	
	
	for(int i=0; i<size; ++i)
	{
		for(int j=i+1; j<size; ++j)
		{
			int temp = X - (arr[i]+arr[j]);

			if(HASH[temp] == 1)
				printf(" %d,%d,%d ", arr[i], arr[j], temp);
			
		}	
		HASH[arr[i]] = 1;	
	}
}
int main()
{
	int arr[] = {1, 4, 45, 6, 10, 8};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	int X = 22;
	
	FindTriplet(arr, n, X);
}	
