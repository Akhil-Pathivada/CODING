/*
Given a positive (or unsigned) integer n, write a function to toggle all the bits except k-th bit. Here value of k starts from 0 (zero) and from right. 
*/

#include<stdio.h>

int toggleExceptK(int n,int k)
{
	return ~( n^(1<<k));
}

void main()
{
	int n=15;
	int k=2;
	
	printf(" %d ",toggleExceptK(n,k));
}
