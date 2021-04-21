//Find the Equilibrium Index (leftSum==rightSum)
//Time Complexity :: O(n)
//Space Complexity :: O(1)
#include<stdio.h>
#include<stdlib.h>
void PrintArray(int *arr,int size)
{
	printf("\n ARRAY :: ");
	for(int i=0;i<size;i++)
	{
		printf(" %d,",arr[i]);
	}
	printf("\n");
}
int findEquilibrium(int *arr,int size)
{
	int rightSum=0,leftSum=0;
	for(int i=0;i<size; rightSum+=arr[i++]);
	for(int i=0;i<size;i++)
	{
		rightSum-=arr[i];
		if(leftSum==rightSum)	
			return arr[i];
		leftSum+=arr[i];
	}
	return -1;
}
int main()
{
	int *arr,size;
	printf("\nEnter size of the Array :: ");
	scanf("%d",&size);
	arr=(int*)malloc(sizeof(int)*size);
	printf("\nEnter the Array :: ");
	for(int i=0;i<size;i++)
	{
		scanf("%d",&arr[i]);
	}
	PrintArray(arr,size);
	printf("\n**EQUILIBRIUM INDEX :: %d **\n",findEquilibrium(arr,size));
}
