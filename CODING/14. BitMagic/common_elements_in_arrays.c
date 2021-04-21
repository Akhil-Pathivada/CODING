//Count number of common elements in two Arrays,without using '==' operator.......
#include<stdio.h>
int countCommon(int *arr1,int *arr2,int N)
{
	int sum=0;
	for(int i=0;i<N;i++)
	{
		for(int j=0;j<N;j++)
			sum+= !(arr1[i]^arr2[j])?1:0;
	}
	return sum;
}
int main()
{
	int N=6;
	int arr1[N], arr2[N];
	printf(" enter Array1 : ");
	for(int i=0;i<N;i++)
		scanf("%d",&arr1[i]);
	printf(" enter Array2 : ");
	for(int i=0;i<N;i++)
		scanf("%d",&arr2[i]);
	printf("\n Total Common elements: %d \n",countCommon(arr1,arr2,N));
}
