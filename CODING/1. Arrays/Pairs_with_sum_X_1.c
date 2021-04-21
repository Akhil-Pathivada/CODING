/*
Given an Array, Find the pairs whose sum is equal to a number 'X'
 Time Complexity :: O(n^2)
*/

#include<stdio.h>
#include<stdlib.h>

void SumPair(int *arr,int n,int X)
{
	int i,j;
	printf("Pairs :: ");
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			if(arr[i]+arr[j]==X)
				printf(" (%d,%d),",arr[i],arr[j]);
		}
	}
}
int main()
{
	int *arr,i,size;

	printf("\nEnter size :: ");
	scanf("%d",&size);
	arr=(int*)malloc(sizeof(int)*size);

	printf("\nEnter the Array :: ");
	for(i=0;i<size;i++)
		scanf("%d",&arr[i]);
	int X=23;
	SumPair(arr,size,X);
}
