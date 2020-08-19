/* Given an Array of positive numbers, find the smallest number that can't be formed with the sum of numbers in that Array....
 Time Complexity :: O(n*logn)+O(n)
*/
/* Added comment */
#include<stdio.h>
#include<stdlib.h>
void Display(int *arr,int n)
{
	printf("\n ARRAY :: ");
	for(int i=0;i<n;i++)
	{
		printf(" %d,",*arr++);
	}
	printf("\n");
}
void findNumber(int *arr,int n)
{
	int res=1;
	for(int i=0;i<n && arr[i]<=res;i++)
	{
		res+=arr[i];
	}
	printf("\n **Smallest number sum :: %d  **\n",res);
}
int main()
{
	int *arr,n;
	printf("\nEnter Size of the Array :: ");
	scanf("%d",&n);
	arr=(int*)malloc(sizeof(int)*n);
	printf("\nEnter the Array (SORTED only):: ");
	for(int i=0;i<n;i++)
	{
		scanf("%d",&arr[i]);
	}
	Display(arr,n);
	findNumber(arr,n);
}
