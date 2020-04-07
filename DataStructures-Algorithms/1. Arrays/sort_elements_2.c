/*
Sort an array of 0s, 1s and 2s

Time Complexity : O(n)
Space Complexity : O(Constant)
*/
#include<stdio.h>

int main()
{
	int arr[]={2,1,0,1,1,2,0,1};
	int countArray[3]={0};
	int k=-1;

	for(int i=0;i<8;++i)
		countArray[arr[i]]++;

	for(int i=0;i<3;++i)
	{
		for( ;countArray[i]; --countArray[i])
			arr[++k]=i;
	}

	for(int i=0;i<8;++i)
		printf(" %d,",arr[i]);
}
