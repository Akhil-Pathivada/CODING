//Write a program to find the smallest of three integers, without using any of the comparison operators. 
#include<stdio.h>
int findMin(int x,int y)
{
	return (x/y)?y:x;
}
void main()
{
	printf(" Min : %d \n",findMin(10,findMin(9,7)));
}
