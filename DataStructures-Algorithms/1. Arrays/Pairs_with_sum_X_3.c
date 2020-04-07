/*
 Given an Array, Find the pairs whose sum is equal to a number 'X'
 Time Complexity :: O(n*logn)
 Space Complexity :: O(1)
*/
#include <stdio.h>
#include <stdlib.h>
#define MAX 10000

//Merge Sort (starts)
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

void MergeSort(int *arr,int size,int p,int r)
{
	if(p<r)
	{
		int q=(p+r)/2;
		MergeSort(arr,size,p,q);
		MergeSort(arr,size,q+1,r);
		MERGE(arr,p,q,r);
	}
}
//Merge Sort (ends)

void SumPairs(int *arr,int size,int X)
{
	int left=0,right=size-1;

	while(left<right)
	{
		if(arr[left]+arr[right]<X) 
			left++;
		else if (arr[left]+arr[right]>X) 
			right++;
		else
			printf(" (%d,%d),",arr[left],arr[right]),left++,right--;
	}
}

int main()
{
	int *arr,size,X;
	printf("\nEnter size :: ");
	scanf("%d",&size);
	arr=(int*)malloc(sizeof(int)*size);

	printf("\nEnter the Array :: ");
	for(int i=0;i<size;i++)
		scanf("%d",&arr[i]);

	printf("\nEnter X :: ");
	scanf("%d",&X);

	MergeSort(arr,size,0,size-1);
	SumPairs(arr,size,X);
}
