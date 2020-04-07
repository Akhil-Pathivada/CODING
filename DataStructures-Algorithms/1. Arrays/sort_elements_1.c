/*
Sort an array of 0s, 1s and 2s

Time Complexity : O(n^2)
Space Complexity : O(1)
*/
#include<stdio.h>

void Swap(int *a,int *b)
{
	int temp=*a;
	*a=*b;
	*b=temp;
}

void BubbleSort(int *arr,int N)
{
	for(int i=0;i<N-1;i++)
	{
		for(int j=i+1;j<N;j++)
		{
			if(arr[i]>arr[j])
				Swap(&arr[i],&arr[j]);
		}
	}
}

int main()
{
	int arr[]={2,1,0,1,1,2,0,1};
	BubbleSort(arr,8);
	for(int i=0;i<8;i++)
		printf(" %d,",arr[i]);
}
