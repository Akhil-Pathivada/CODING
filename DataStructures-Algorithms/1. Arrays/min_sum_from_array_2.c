/*Minimum sum of two numbers formed from digits of an array

Given an array of digits (values are from 0 to 9), find the minimum possible sum of two numbers formed from digits of the array. 
All digits of given array must be used to form the two numbers.  

-------------------------------------------------------------    */
/*
Time Complexity :: O(n)....COUNTING SORT
Space Complexity :: O(1)
*/

#include<stdio.h>
#include<stdlib.h>
int fre[10]={0}; //O(constant)

void Sort(int *arr,int N) // O(n)
{
	for(int i=0;i<N;i++)
		fre[arr[i]]++;
		
	int j=0;
	for(int i=0;i<10;i++) // updating the Array....O(constant)
	{
		while(fre[i]>0)
		{
			arr[j++]=i;
			fre[i]--;
		}
	}
}
int getMinSum(int *arr,int N) // O(n)
{
	Sort(arr,N);
	int num1=0,num2=0;
	for(int i=0;i<N;i++)
	{
		if(i%2==0)
			num1= (num1*10)+arr[i] ;
		else
			num2= (num2*10)+arr[i] ;
	}
	return num1+num2;
}
void main()
{
	int *arr,N;
	printf(" enter size of the Array :: ");
	scanf("%d",&N);
	arr=(int*)malloc(sizeof(int));
	printf(" enter the Array (SORTED only): ");
	for(int i=0;i<N; scanf("%d",&arr[i++]) );
	printf(" initial Array : ");
	for(int i=0;i<N; printf(" %d,",arr[i++]) );
	printf("\n Min Sum : %d \n",getMinSum(arr,N));
}
