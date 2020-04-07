/*
Group all the occurences of an element order by their first occurence....

Time Complexity : O(n^2).....Amortised analysis
Space Complexity : O(1)
*/

#include<stdio.h>

void shiftElements(int *arr,int i,int j) // O(n)
{
	int temp=arr[j];

	for( ;j>i;j--)
		arr[j]=arr[j-1];

	arr[i]=temp;
}

void groupOccurences(int arr[],int N) // O(n)
{
	for(int i=0;i<N;i++)
	{
		for(int j=i+1;j<N;j++)
		{
			if(arr[i]==arr[j])
				shiftElements(arr,i+1,j);
		}
	}
}

int main()
{
	int arr[]={3,6,1,2,3,4,1,2,1};

	groupOccurences(arr,9);

	for(int i=0;i<9;i++)
		printf(" %d,",arr[i]);
}
