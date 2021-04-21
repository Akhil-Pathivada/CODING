/*
Swap three variables without using temporary variable

*/

#include<stdio.h>

void Swap(int a,int b,int c)
{
	a=a+b+c;
	
	b=a-(b+c);
	
	c=a-(b+c);
	
	a=a-(b+c);
 
	printf(" a: %d \n b: %d \n c: %d \n",a,b,c);
}

void main()
{
	int a=10,b=20,c=30;
	
	Swap(a,b,c);
}
