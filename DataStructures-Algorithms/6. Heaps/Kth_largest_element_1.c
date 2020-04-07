/*
Given an array and a number k where k is smaller than size of array, we need to find the k’th largest element in the given array. 
It is given that all array element are distinct.

Time Complexity : O(n*k)
Space Complexity : O(1)
*/

#include<stdio.h>

void Swap(int *aptr,int *bptr)
{
	int temp = *aptr;
	*aptr = *bptr;
	*bptr = temp;
}

int KthLargestElement(int *arr,int K,int N)
{
	int max;
	
	for(int j=0;j<K;++j)
	{
		max = 0;
		
		for(int i=1; i<=N; ++i)
			max = (arr[i]>arr[max]) ? i : max;
			
		Swap(&arr[max], &arr[N--]);
	}
	return ++N;	
}

void main(void)
{
	int arr[] = {1, 3, 2, 9, 21, 6, 34};
	
	int N = sizeof(arr)/sizeof(*arr);
	
	int index = KthLargestElement(arr,3,N-1);
	
	printf("Kth largest element : %d ",arr[index]);
}
