/*
Given an array of size n and an integer k, return the of count of distinct numbers in all windows of size k. 

Time Complexity : O(n*(k^2))
Space Complexity : (1)
*/

#include<stdio.h>

void countDistinctElements(int arr[],int K,int N)
{
	for(int i=0; i<N-K+1 ;i++) // O(n)
	{
		int dcount=0;

		for(int j=0;j<K;j++) // O(K)
		{
			int flag=0;

			for(int k=0;k<K;k++) // O(K)
			{
				if( j!=k && (arr[i+j]==arr[i+k]) )
					flag=1;		
			}

			if(!flag)
				dcount++;	
		}

		printf(" %d,",dcount);
	}
}
int main()
{
	int arr[]={1,2,1,4,4,3,3,4,1,8,1};

	int size=sizeof(arr)/sizeof(*arr);

	countDistinctElements(arr,3,size);
}
