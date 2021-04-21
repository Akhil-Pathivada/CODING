/*
Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s.

Time Complexity : O(n)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdlib.h>
#include<limits.h>

struct HASH
{
	int sum,index;
}*HashTable;

int H(int x,int MAX)
{
	int i,k=abs(x)%MAX;

	if(HashTable[k].index== -1)
		return k;

	for(i=(k+1)%MAX ; (HashTable[i].index!= -1) && i!=k ; i=(i+1)%MAX);

	return i;
}

void insertHash(int sum,int index,int N)
{
	int x=H(sum,N);

	HashTable[x].sum=sum;
	HashTable[x].index=index;
}

int searchHash(int target,int MAX)
{
	int i,k=abs(target)%MAX;

	if(HashTable[k].sum==target)
		return k;

	for(i=(k+1)%MAX ; (HashTable[i].sum!=target) && i!=k  ; i=(i+1)%MAX);

	return (i==k)?-1:i;
}

void findLargestSubArray(int arr[],int N)
{
	HashTable=(struct HASH*)malloc(sizeof(struct HASH)*N);

	for(int i=0;i<N;i++)
		HashTable[i].index=-1;

	for(int i=0;i<N;i++)
		arr[i]=arr[i] ?1:-1;

	int startIndex,lastIndex,currSum=0,maxLength=-1;

	for(int i=0;i<N;i++)
	{
		currSum+=arr[i];

		int pos=searchHash(currSum,N);

		if(pos!= -1)
		{
			int length = i-HashTable[pos].index;

			if(length>maxLength)
			{
				startIndex=HashTable[pos].index+1;
				lastIndex=i;
				maxLength=length;
			}
			
		}
		else
			insertHash(currSum,i,N);
	}

	if(maxLength)
		printf( maxLength ? " Largest Sub Array from %d to %d \n",startIndex,lastIndex);
	else
		printf(" No SubArray found\n");
}

int main()
{
	int arr[]={1,0,1,1,0,1};
	findLargestSubArray(arr,6);
}
