/*Program to find two repeating numbers in a given array

You are given an array of n+2 elements. 
All elements of the array are in range 1 to n.
And all elements occur once except two numbers which occur twice. Find the two repeating numbers. 

Time Complexity :: O(n)
Space Complexity :: O(n)
*/

#include<stdio.h>
#define MAX 4

int arr[MAX+2],temp[MAX]={0};

void findRepeats(int *arr,int *temp)
{
	printf("\n Repeating two Numbers ::");

	for(int i=1;i<=MAX+2;i++)
	{
		temp[arr[i]]++;

		if(temp[arr[i]]>1) 
			printf(" %d ,",arr[i]);
	}
}

void Display(int *arr)
{
	for(int i=1; i<=MAX+2; printf("%d,",arr[i++]));
}

int main()
{
	printf("\nEnter Array :: \n");

	for(int i=1;i<=MAX+2;scanf("%d",&arr[i++]));

	Display(arr);
	findRepeats(arr,temp);
}
