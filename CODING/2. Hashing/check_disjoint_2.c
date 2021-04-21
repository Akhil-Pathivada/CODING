/*
Check whether two arrays are Disjoint or not....

Time Complexity : O(m*logm)+O(n*logm)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

void MERGE(int *arr,int p,int q,int r)
{
	int n1=q-p+1;
	int n2=r-q;

	int *Left,*Right,i,j,k;

	Left=(int*)malloc(sizeof(int)*n1);

	Right=(int*)malloc(sizeof(int)*n2);

	for(i=0;i<n1;i++)
		Left[i]=arr[p+i];

	for(j=0;j<n2;j++)
		Right[j]=arr[q+j+1];

	Left[n1]=999,Right[n2]=999;
	i=0,j=0,k=0;

	for(k=p;k<=r;k++)
	{
		if(Left[i]<=Right[j])
			arr[k]=Left[i++];
		else
			arr[k]=Right[j++];
	}
}

void MergeSort(int *arr,int p,int r) // O(m*logm)
{
	if(p<r)
	{
		int q=(p+r)/2;

		MergeSort(arr,p,q);

		MergeSort(arr,q+1,r);

		MERGE(arr,p,q,r);
	}
}
bool BinarySearch(int arr[],int target,int start,int end) //O(logn)
{
	while(start<=end)
	{
		int mid=(start+end)/2;

		if(arr[mid]==target)
			return true;

		if(arr[mid]<target)
			start=mid+1;
		else
			end=mid-1;
	}

	return false;
}

bool checkDisjoint(int arr1[],int arr2[],int m,int n) // O(n)*O(logm)
{
	for(int i=0;i<n;i++) 
	{
		if(BinarySearch(arr1,arr2[i],0,m))
			return true;
	}

	return false;
}

int main()
{
	int arr1[]={5,4,1,2,3};
	int arr2[]={6,7,9,23,15,33,5};

	MergeSort(arr1,0,4);

	checkDisjoint(arr1,arr2,5,7) ? printf("TRUE") : printf("FALSE");
}
