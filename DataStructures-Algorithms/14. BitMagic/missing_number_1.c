//You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in the list.
// Find the missing number....
// Time Complexity :: O(n) 
#include<stdio.h>
int findMissingNumber(int *arr,int N)
{
	int sum=(N*(N+1))/2;
	for(int i=0;i<N-1;i++)
		sum-=arr[i];
	return sum;
}
int main()
{
	int N;
	printf(" enter N : ");
	scanf("%d",&N);
	int arr[N];
	printf(" enter the Array : ");
	for(int i=0;i<N-1;i++)
		scanf("%d",&arr[i]);
	printf(" ARRAY :: ");
	for(int i=0;i<N-1;i++)
		printf(" %d,",arr[i]);
	printf("\n Missing Number : %d \n",findMissingNumber(arr,N));
}
