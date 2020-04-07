/*
Given an array of size n and an integer k, return the of count of distinct numbers in all windows of size k. 

Time Complexity : O(N*(K*logK))
Space Complexity : O(K)
*/

#include<stdio.h>
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

	for(k=p; k<=r; ++k)
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

void countDistinctElements(int arr[],int K,int N)
{
	for(int i=0; i < N-K+1 ;i++) // O(n)
	{
		int temp[K];

		for(int j=0;j<K;j++)
			temp[j]=arr[i+j];

		MergeSort(temp,0,K-1); // O(K*logK)
		
		int j,dcount=0;

		for(j=0; j<K-1; j++)
		{
			int flag=0;

			for( ;temp[j]==temp[j+1]; j++)
				flag++;

			if(!flag)
				dcount++;
		}

		if(j==K-1)
			++dcount;
	
		printf(" %d,",dcount);
	}
}

int main()
{
	int arr[]={1,2,1,4,4,3,3,4,1,8,1};

	int size=sizeof(arr)/sizeof(*arr);

	countDistinctElements(arr,3,size);
}
