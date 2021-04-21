//Swap two numbers using XOR.....
#include<stdio.h>
void Swap(int *x,int *y)
{
	int XOR= *x ^ *y;
	*x=*x ^ XOR;
	*y=*y ^ XOR;
}
void main()
{
	int x=12,y=34;
	Swap(&x,&y);
	printf(" x : %d\n y : %d \n",x,y);
}
