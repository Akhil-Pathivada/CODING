/*
Given an array,for each element find the closest greater element which is present on the right side of that element....

Time Complexity : O(n^2)
Space Complexity : O(1)
*/

#include<stdio.h>
#define MAX 7

int arr[MAX],res[MAX];

void printArray(int *a)
{
	for(int i=0;i<MAX;printf("  %d,",a[i++]));	
}

void getClosest()
{
	for(int i=0;i<MAX;i++)
	{
		for(int j=i+1;j<MAX;j++)
		{
			if(arr[j]>arr[i])
			{
				res[i]=arr[j];
				break;
			}
		}
	}
}

void main()
{
	int val,ch;
	do
	{
		printf("\n\t1.Insert into Array");
		printf("\n\t2.Print Array");
		printf("\n\t3.Get_Closer Elements");
		printf("\n Enter U R Choice :: ");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1 : 
				printf("\n Enter the elements to Insert :: ");
				for(int i=0;i<MAX;scanf("%d",&arr[i++]));
				break;
			case 2:
				printf("\n ARRAY ::");
				printArray(arr);
				break;
			case 3 :
				getClosest();	
				printf("\n RESULT ::");
				printArray(res);
				break;
		}
	}while(ch<4);	
}
