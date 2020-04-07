/*
Program to get the Nth Fibanocci number......

Time Complexity : O(n)
Space Complexity : O(1)

*/
#include<stdio.h>

int getNthFibanocci( int n)
{
	int a=0;
	int b=1;
	
	for( int i=2; i<=n; ++i)
	{
		int fibo = a+b;
		a=b;
		b=fibo;		
	}
		
	return b;
}

void main()
{
	int n=9;
	
	printf(" %d ",getNthFibanocci(n));
}
