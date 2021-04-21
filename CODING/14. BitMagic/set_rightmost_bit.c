// Set the Rightmost bit in a Binary number
#include<stdio.h>
int setBit(int num)
{
	return num&(num-1);
}
void main()
{
	int num;
	printf(" enter a number : ");
	scanf("%d",&num);
	printf(" RESULT : %d \n",setBit(num));
}
