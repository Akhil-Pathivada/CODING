/*
Check if a given array contains duplicate elements within k distance from each other.

Time Complexity : O(n*k)
Space Complexity : O(1)
*/

#include<stdio.h>

int checkDuplicates(int arr[],int N,int K)
{
	for(int i=0;i<N-1;i++)
	{
		for(int j=1; j<=K && i+j < N ;j++)
		{
			if(arr[i]==arr[i+j])
				return 1;
		}
	}

	return 0;
}

int main()
{
	int arr[8],K;

	printf("enter Array : ");
	for(int i=0;i<8;i++)
		scanf("%d",&arr[i]);

	printf("enter K : ");
	scanf("%d",&K);

	checkDuplicates(arr,8,K) ? printf(" YES\n") :printf(" NO\n");
}
