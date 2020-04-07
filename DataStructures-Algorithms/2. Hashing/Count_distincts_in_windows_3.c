/*
Given an array of size n and an integer k, return the of count of distinct numbers in all windows of size k. 

Time Complexity : O(N*K)
Space Complexity : O(K)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct HASH
{
	int data,freq;
};

int H(struct HASH *hash,int val,int MAX) // O(1)
{
	int i, key = val%MAX;

	if(!hash[key].data)
		return key;

	for(i=(key+1)%MAX ; hash[i].data && i!=key ; i=(i+1)%MAX);

	return i;
}

void insertHash(struct HASH *hash,int val,int MAX) // O(1)
{
	int key = H(hash,val,MAX);

	hash[key].data=val;
	hash[key].freq++;
}

bool searchHash(struct HASH *hash,int target,int MAX) // O(1)
{
	int i, key = target%MAX;

	if(hash[key].data==target)
	{
		hash[key].freq++;
		return true;
	}

	for(i=(key+1)%MAX ; hash[i].data!=target && i!=key ; i=(i+1)%MAX);

	if(hash[i].data==target)
	{
		hash[i].freq++;
		return true;
	}

	return false;	
}

void countDistinctElements(int arr[],int K,int N)
{
	for(int i=0; i<N-K+1 ;i++) // O(n)
	{
		int dcount=0;

		struct HASH *hash = (struct HASH *)malloc(sizeof(struct HASH)*K);
		
		for(int j=0;j<K;j++)
		{
			if( !searchHash(hash,arr[i+j],K) )
				insertHash(hash,arr[i+j],K);
		}
	
		for(int j=0;j<K;j++)
		{
			if(hash[j].freq==1)
				dcount++;
		}

		printf(" %d,",dcount);
	}
}

int main()
{
	int arr[]={1,2,1,4,4,3,3,4,1,8,1};

	int size=sizeof(arr)/sizeof(*arr);

	countDistinctElements(arr,4,size);
}
