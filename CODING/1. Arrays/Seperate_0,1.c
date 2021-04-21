/*

Seperate the ZEROs to the LEFT && ONEs to the RIGHT side of the Array

Time Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>

void PrintArray(int *arr,int size)
{
	for(int i=0;i<size;i++)
		printf(" %d",arr[i]);

	printf("\n");
}

void Swap(int *x,int *y)
{
	int temp=*x;
	*x=*y;
	*y=temp;
}

void Seperate(int *arr,int size)
{
	int left=0,right=size-1;
	while(left<right)
	{
		if(arr[left]==0) 
			left++;

		if(arr[right]==1) 
			right--;

		if(arr[left]==1 && arr[right]==0)
		{
			Swap(&arr[left],&arr[right]);
			left++;
			right--;
		}
	}
}

int main()
{
	int *arr,i,size;

	printf("\nEnter size :: ");
	scanf("%d",&size);

	arr=(int*)malloc(sizeof(int)*size);

	printf("\nEnter Array (0,1) :: ");
	for(i=0;i<size;i++)
		scanf("%d",&arr[i]);

	Seperate(arr,size);
	PrintArray(arr,size);
}
