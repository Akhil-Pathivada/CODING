/*
Moore Voting Algorithm

Time Complexity :: O(n)
Space Complexity :: O(1)
*/
#include<stdio.h>
#include<stdlib.h>

int checkMajority(int *arr,int size,int voter)
{
	int count=0;
	for(int i=0;i<size;i++)
	{
		if(arr[i]==voter)
			 count++;
	}

	return count>size/2?1:0;
}

void getMajority(int *arr,int size)
{
	int voter,votes=0,i;
	voter=arr[0];

	for(i=0;i<size;i++)
	{
		if(arr[i]==voter)
		        votes++;
		else
			votes--;
		if(votes==0) 
			voter=arr[i],votes=1;
	}

	int flag=checkMajority(arr,size,voter);

	if(flag)
		printf("\n**Majority Element :: %d **\n",voter);	
	else
 		printf("\n**No Majority Element was found**\n");
}

int main()
{
	int *arr,i,size;
	printf("\nEnter size of the Array :: ");
	scanf("%d",&size);

	arr=(int*)malloc(sizeof(int)*size);

	printf("\nEnter the Array :: ");
	for(i=0;i<size;i++)
		scanf("%d",&arr[i]);

	getMajority(arr,size);
}

