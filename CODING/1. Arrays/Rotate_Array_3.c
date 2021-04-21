/*
Program to rotate array of size 'n' by 'd' elements

Time Complexity : O(n)
Space Complexity : O(1)
*/
#include<stdio.h>
#include<stdlib.h>
int GCD(int x,int y)
{
	return !y ? x : GCD(y,x%y);
}
void printArray(int *a,int n)
{
	for(int i=0;i<n;printf(" %d,",a[i++]));
}
void rotateArray(int *arr,int n,int d)
{
	int i,j,temp;
	int gcd = GCD(n,d); 
    	for (i = 0; i < gcd; i++) 
    	{ 
        	/* move i-th values of blocks */
        	temp = arr[i]; 
        	j = i; 
        	while (1)
        	 { 
        	    k = j + d; 
        	    if (k >= n) 
        	        k = k - n; 
        	    if (k == i) 
        	        break; 
        	    arr[j] = arr[k]; 
        	    j = k; 
        	} 
        	arr[j] = temp; 
    	} 
}
void main()
{
	int *arr,n,d,gcd;
	printf("\nEnter N :: ");
	scanf("%d",&n);
	printf("\nEnter ARRAY :: ");
	for(int i=0;i<n;scanf("%d",&arr[i++]));
	printArray(arr,n);
	printf("\nEnter d :: ");
	scanf("%d",&d);
	rotateArray(arr,n,d);
	printArray(arr,n);
	printf("\n");
}

