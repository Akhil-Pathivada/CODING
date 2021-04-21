// Bubble Sort

#include<stdio.h>
#include<stdlib.h>

void PrintArray(int *arr,int size)
{
	printf("\nArray :: ");

	for(int i=0;i<size;i++)
		printf(" %d,",arr[i]);
}

void Swap(int *p,int *q)
{
	int temp=*p;
	*p=*q;
	*q=temp;
}

void bubbleSort(int *arr,int n)
{
	for(int i=0;i<n;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			if(arr[i]>arr[j])
				Swap(&arr[i],&arr[j]);
		}	
	}
}

int main()
{
	int *arr,size;

	printf("\nEnter size of the Array :: ");	
	scanf("%d",&size);	

	arr=(int*)malloc(sizeof(int)*size);	

	printf("\nEnter the Array :: ");	
	for(int i=0;i<size;i++)
		scanf("%d",&arr[i]);

	PrintArray(arr,size);
	bubbleSort(arr,size);

	printf("** Sorted Successfully **");

	PrintArray(arr,size);
}
