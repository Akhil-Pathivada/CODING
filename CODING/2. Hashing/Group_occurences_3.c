/*
Group all the occurences of an element order by their first occurence....

Time Complexity : O(n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct HASH
{
	int data,freq;
}*HashTable;

int H(int val,int MAX) // O(1)
{
	int i, key=val%MAX;

	if(!HashTable[key].data)
		return key;

	for(i=(key+1)%MAX ; HashTable[i].data && i!=key ; i=(i+1)%MAX);

	return i;
}

void insertHash(int val,int MAX) // O(1)
{
	int key=H(val,MAX);
	HashTable[key].data=val;
	HashTable[key].freq++;
}

bool searchHash(int target,int MAX) // O(1)
{
	int i, key=target%MAX;

	if(HashTable[key].data==target)
	{
		HashTable[key].freq++;
		return true;
	}

	for(i=(key+1)%MAX ; HashTable[i].data!=target && i!=key ; i=(i+1)%MAX);

	return (i==key) ? false :true;	
}

struct HASH* getNode(int target,int MAX) // O(1)
{
	int i, key=target%MAX;

	if(HashTable[key].data==target)
		return HashTable+key;

	for(i=(key+1)%MAX ; HashTable[i].data!=target && i!=key ; i=(i+1)%MAX);

	return  (HashTable+i);	
}

void groupOccurences(int arr[],int res[],int N) // O(n)
{
	for(int i=0;i<N;i++)
	{
		struct HASH *node=getNode(arr[i],N);

		for( ;(*node).freq ; (*node).freq--) 
			*(res++)=arr[i];
	}
}
int main()
{
	int arr[]={3,6,1,2,3,4,1,2,1};

	int res[9];

	HashTable=(struct HASH*)malloc(sizeof(struct HASH)*9);

	for(int i=0;i<9;i++)
	{
		if(!searchHash(arr[i],9))
			insertHash(arr[i],9);
	}

	groupOccurences(arr,res,9);

	for(int i=0;i<9;i++)
		printf(" %d,",res[i]);
}
