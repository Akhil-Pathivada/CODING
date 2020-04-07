// A Simple example on Pointers

#include<stdio.h>
#include<ctype.h>
int main()
{
	int x=5;
	int *y=&x;
	printf("\n x :: %d",x);
	printf("\n &x :: %p",&x);
	printf("\n y :: %p",y);
	printf("\n *y :: %d",*y);
	printf("\n &y :: %p \n",&y);
}

