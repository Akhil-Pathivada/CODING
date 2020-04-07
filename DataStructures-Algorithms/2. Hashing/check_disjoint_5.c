/*
Check whether two arrays are Disjoint or not....

Time Complexity : O(n)
Space Complexity : O(m)
*/
#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

int *HashTable;

int H(int val,int MAX) // O(1)
{
	int i,key=val%MAX;

	if(!HashTable[key])
		return key;

	for(i=(key+1)%MAX ; HashTable[i] && i!=key ; i=(i+1)%MAX);

	return i;
}

void insertHash(int val,int MAX) // O(1)
{
	int key=H(val,MAX);

	HashTable[key]=val;
}

bool searchHash(int target,int MAX) // O(1)
{
	int i,key=target%MAX;

	if(HashTable[key]==target)
		return true;

	for(i=(key+1)%MAX ; HashTable[i]!=target && i!=key ; i=(i+1)%MAX);

	return (i==key) ? false :true;	
}

bool checkDisjoint(int arr2[],int m,int n) //O(n)
{
	for(int i=0;i<n;i++)
	{
		if(searchHash(arr2[i],m))
			return true;
	}
	return false;
}

int main()
{
	int arr1[]={2,4,1,5,3};
	int arr2[]={12,4,9,19,29,15,16};

	HashTable=(int*)malloc(sizeof(int)*5);

	for(int i=0;i<5;i++)
		insertHash(arr1[i],5);

	checkDisjoint(arr2,5,7)? printf("TRUE \n"):printf("FALSE \n");
}
