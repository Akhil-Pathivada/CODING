//Write a program to find the smallest of three integers, without using any of the comparison operators. 
#include<stdio.h>
int findMin(int x,int y,int z)
{
	int count=0;
	while(x&&y&&z)
	{
		x--;
		y--;
		z--;
		count++;
	}
	return count;
}
void main()
{
	printf(" Min : %d \n",findMin(10,9,7));
}
