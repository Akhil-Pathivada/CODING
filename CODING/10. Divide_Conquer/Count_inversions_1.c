/*
Count inversions in an Array

The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

Time Complexity : O(n^2)
Space Complexity : O(1)
*/

#include<stdio.h>

int countInversions(int *arr,int size)
{
	int invCount=0;
	
	for(int i=0; i<size; ++i)
	{
		for(int j=i+1; j<size; ++j)
		{
			if(arr[i] > arr[j])
				++invCount;
		}	
	}
	return invCount;
}

int main()
{
	int arr[]={3,2,5,7,4,1,6};
	int size=sizeof(arr)/sizeof(*arr);
	
	printf(" total inversions : %d ",countInversions(arr,size));
}
