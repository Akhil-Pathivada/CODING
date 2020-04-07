/*
Given an Array, Find the pairs whose sum is equal to a number 'X'

 Time Complexity :: O(n)
 Space Complexity :: O(n)
 Using Hash Approach
*/
#include <stdio.h>
#include <stdlib.h>
#define MAX 10000

void SumPairs(int *arr,int size,int X)
{
	int hash[MAX]={0},temp;

	printf("\nPairs :: ");
	for(int i=0;i<size;i++)
	{
		temp=X-arr[i];
		if(temp>=0 && hash[temp]==1)
			printf(" (%d,%d),",arr[i],temp);
		hash[arr[i]]=1;
	}	
}

int main()
{
	int *arr,size;

	printf("\nEnter size :: ");
	scanf("%d",&size);
	arr=(int*)malloc(sizeof(int)*size);

	printf("\Enter the Array :: ");
	for(int i=0;i<size;i++)
		scanf("%d",&arr[i]);

	int X=23;
	SumPairs(arr,size,X);
}
