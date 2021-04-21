/*
 Counting Sort 

 Time Complexity :: O(n+k)
 Space Complexity :: O(k)
*/

#include<stdio.h>
#include<stdlib.h>
#define K 5

void PrintArray(int *arr,int n)
{
	printf("\nARRAY :: ");
	for(int i=0;i<n;i++)
		printf(" %d,",arr[i]);
}

void countingSort(int *arr,int *temp,int N)
{
	for(int i=0;i<N;i++)
	{
		temp[arr[i]]++;
	}
	printf("\n** SORTED ARRAY :: ");
	for(int i=0;i<K;i++)
	{
		while(temp[i]>0)
		{
			printf(" %d,",i),temp[i]--;
		}
	}
	printf(" **\n");
}

int main()
{
	int *arr,temp[K]={0},N;
	printf("\nEnter SIZE :: ");
	scanf("%d",&N);	

	arr=(int*)malloc(sizeof(int)*N);
	printf("\nEnter the Array (0-4):: ");	
	for(int i=0;i<N;i++)
		scanf("%d",&arr[i]);

	PrintArray(arr,N);
	countingSort(arr,temp,N);
}
