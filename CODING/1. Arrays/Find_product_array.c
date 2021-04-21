/*
Given an array of n-integers, Construct the Product Array, such that Prod[i] is equal to product of all elements except arr[i], without using 'division' operator......
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

#include<stdio.h>
#include<stdlib.h>
void Display(int *arr,int N)
{
	printf("\n ARRAY :: ");
	for(int i=0; i<N; printf(" %d,",arr[i]),i++);
}
int *pro,*leftArr,*rightArr;

void findProduct(int *arr,int N)
{
	int i=0,temp=1;
	
	for(i=0; i<N; i++)
		pro[i]=temp,temp*=arr[i];
		
	for(i=N-1,temp=1 ;i>=0; i--)
		pro[i]*=temp,temp*=arr[i];
}
void main()
{
	int *arr,N;
	printf("\nEnter the SIZE :: ");
	scanf("%d",&N);
	arr=(int*)malloc(sizeof(int)*N);
	pro=(int*)malloc(sizeof(int)*N);
	leftArr=(int*)malloc(sizeof(int)*N);
	rightArr=(int*)malloc(sizeof(int)*N);
	printf("\nEnter the Array :: ");
	for(int i=0;i<N;i++)
	{
		scanf("%d",&arr[i]);
	}
	Display(arr,N);
	findProduct(arr,N);
	Display(pro,N);
	printf("\n");
}
