/*
 Program to HEAP SORT
 Time Complexity :: O(n*logn)

*/

#include<stdio.h>
#include<stdlib.h>

void Swap(int *p,int *q)
{
	int temp=*p;
	*p=*q;
	*q=temp;
}

void Max_Heapify(int *arr,int size,int i) // O(logn)
{
	int largest=i;

	int left=(2*i)+1;

	int right=(2*i)+2;

	if(left<size && arr[left]>arr[i])
		largest=left;

	if(right<size && arr[right]>arr[largest])
		largest=right;

	if(largest!=i)
	{
		Swap(&arr[i],&arr[largest]);

		Max_Heapify(arr,size,largest);
	}
}

int main()
{
	int size,*arr;

	printf(" Enter size of the arr : ");
	scanf("%d",&size);

	arr = (int*)malloc(sizeof(int)*size);

	printf(" Enter the elements to be inserted :: ");

	for(int i=0; i<size; i++)
		scanf("%d", &arr[i]);

	printf(" Initial arr :: ");

	for(int i=0; i<size; i++)
		printf("%d",arr[i]);

	for(int i=(size/2)-1 ;i>=0;i--)
		Max_Heapify(arr,size,i);

	for(int i=size-1; i>=1; i--) // O(n)
	{
		Swap(&arr[0],&arr[i]);
		
		Max_Heapify(arr,i,0); // from the start....
	}

	printf("\n Result arr :: ");

	for(int i=0;i<size;i++)
		printf("%d",arr[i]);	
}
