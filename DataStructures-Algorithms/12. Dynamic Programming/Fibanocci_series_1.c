/*
Program to get the Nth Fibanocci number......

Time Complexity : O(2^n)
Space Complexity : O(n)

*/
#include<stdio.h>

int getNthFibanocci( int n)
{
	if(n==0)
		return 0;
		
	if(n==1)
		return 1;
	
	return getNthFibanocci(n-1) + getNthFibanocci(n-2);
}

void main()
{
	int n=9;
	
	printf(" %d ",getNthFibanocci(n));
}
