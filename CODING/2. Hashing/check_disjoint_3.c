/*
Check whether two arrays are Disjoint or not....

Time Complexity : O(m*logm)+O(n*logn)+O(m+n)
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

bool checkDisjoint(int arr1[],int arr2[],int m,int n) // O(m+n)
{
	int i=0,j=0;

	while(arr1[i]!=arr2[j] && i<m && j<n)
	{
		if(arr1[i] < arr2[j])
			i++;
		else
			j++;
	}

	return arr1[i]==arr2[j] ? true : false;
}
int main()
{
	int arr1[]={5,4,1,2,3};
	int arr2[]={6,7,9,23,15,11,3};

	MergeSort(arr1,0,4);
	MergeSort(arr2,0,6);

	checkDisjoint(arr1,arr2,5,7)? printf("TRUE"):printf("FALSE");
}
