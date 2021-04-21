/* Quick Sort

Time Complexity : O(n^2)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>

void PrintArray(int *arr,int size)
{
	for(int i=0;i<size;i++)
		printf(" %d,",arr[i]);
}

void Swap(int *p,int *q)
{
	int temp=*p;
	*p=*q;
	*q=temp;
}

int Partition(int *arr,int low,int high)
{
	int x = arr[high];

	int i = low-1;

	for(int j=low; j<high; ++j)
	{
		if(arr[j] <= x)
		{
			i++;
			
			Swap(&arr[i], &arr[j]);
		}
	}

	Swap(&arr[++i], &arr[high]);

	return i;
}

void quickSort(int *arr,int low,int high)
{
	if(low<high)
	{
		int pivot=Partition(arr,low,high);

		quickSort(arr,low,pivot-1);

		quickSort(arr,pivot+1,high);
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

	quickSort(arr,0,size-1);

	printf("** Sorted Successfully **");

	PrintArray(arr,size);
}
