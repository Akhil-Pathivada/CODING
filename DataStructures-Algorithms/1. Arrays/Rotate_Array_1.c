//Program to rotate array of size 'n' by 'd' elements
//Time Complexity :: O(n)
// Space Complexity :: O(d)
#include<stdio.h>
#define max 20
void Swap(int *p,int *q)
{
	int temp=*p;
	*p=*q;
	*q=temp;
}
void Display(int arr[],int n)
{
	for(int i=0;i<n;printf("%d,",arr[i++]));
	printf("\n");
}
void Rotate(int arr[],int n,int d)
{
	int temp[d],i;
	for(i=0;i<d;i++)
	{
		temp[i]=arr[i];
	}
	for(i=0;i<n-d;i++)
	{
		arr[i]=arr[i+d];
	}
	for(int j=n-d,k=0;j<n;j++)
	{
		arr[j]=temp[k++];
	}
}
int main()
{
	int arr[max],n,d;
	printf("\nEnter n :: ");
	scanf("%d",&n);
	printf("\nEnter Array :: \n");
	for(int i=0;i<n;i++)
	{
		scanf("%d",&arr[i]);
	}
	Display(arr,n);
	printf("\nEnter d :: ");
	scanf("%d",&d);
	Rotate(arr,n,d);
	Display(arr,n);
}
/*
Time Complexity :: O(n)

*/
