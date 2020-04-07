/* 
Find the Triplet whose sum is 'X'

Time Complexity : O(n^3)
Space Complexity : O(1)

*/

#include<stdio.h>
#include<stdlib.h>

void PrintArray(int *arr,int size)
{
	printf("\n ARRAY : ");
	
	for(int i=0; i<size; ++i)
		printf(" %d",arr[i]);
}

void FindTriplet(int *arr,int size,int X)
{
	printf("\n Triplets : ");	
	
	for(int i=0; i<size; ++i)
	{
	      for(int j=i+1; j<size; ++j)
	      {
	      	      for(int k=j+1; k<size; ++k)
	      	      {
	      	      		if(arr[i]+arr[j]+arr[k] == X)
	      	      			printf(" (%d,%d,%d)",arr[i],arr[j],arr[k]);
	      	      }
	      }
	}
}

int main()
{
	int *arr, size;

	printf("\nEnter Size of the Array :: ");
	scanf("%d",&size);
	
	arr = (int*)malloc(sizeof(int)*size);

	printf("\nEnter the Array :: ");
	
	for(int i=0; i<size; ++i)
		scanf("%d",&arr[i]);

	PrintArray(arr,size);
	
	int X = 13;

	FindTriplet(arr,size,X);
}	
