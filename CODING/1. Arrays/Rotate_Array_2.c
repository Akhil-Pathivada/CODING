//Program to rotate array of size 'n' by 'd' elements
//Time Complexity :: O(n*d)
// Space Complexity :: O(1)
#include<stdio.h>
#include<stdlib.h>
/*int gcd(int x,int y)
{
	int rem=x%y;
	if(rem==0)
		return y;
	else
		return gcd(y,rem);
}*/
void printArray(int *a,int n)
{
	for(int i=0;i<n;printf(" %d,",a[i++]));
}
void leftRotate(int *arr,int n)
{
	int temp=*arr;
	for(int i=0;i<n-1;i++)
		arr[i]=arr[i+1];
	arr[n-1]=temp;
}
void rotateArray(int *arr,int n,int d)
{
	int i,j,temp;
	for(i=0;i<d;i++)
	{
		leftRotate(arr,n);
	}
}
void main()
{
	int *arr,n,d;
	printf("\nEnter N :: ");
	scanf("%d",&n);
	printf("\nEnter ARRAY :: ");
	for(int i=0;i<n;scanf("%d",&arr[i++]));
	printArray(arr,n);
	printf("\nEnter d :: ");
	scanf("%d",&d);
	rotateArray(arr,n,d);
	printArray(arr,n);
}

