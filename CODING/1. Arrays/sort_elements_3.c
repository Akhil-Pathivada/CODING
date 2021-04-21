
/*
Sort an array of 0s, 1s and 2s
Dutch National Flag Algorithm, or 3-way Partitioning 

Time Complexity : O(n)
Space Complexity : O(1)
*/
#include<stdio.h>

void Swap(int *a,int *b)
{
	int temp=*a;
	*a=*b;
	*b=temp;
}

int main()
{
	int arr[]={2,1,0,2,0,2,1,1};
	int start=0,mid=0,end=7;
	while(mid<=end)
	{
		switch(arr[mid])
		{
			case 0:
				Swap(&arr[start],&arr[mid]);
				start++,mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				Swap(&arr[mid],&arr[end]);
				end--;
		}
	}

	for(int i=0;i<8;i++)
		printf(" %d,",arr[i]);
}
