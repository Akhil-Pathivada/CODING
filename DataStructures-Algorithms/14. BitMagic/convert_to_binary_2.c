// Convert a Decimal to Binary Number without any Arthimetic operators 

#include<stdio.h>
void Binary(int n)
{
	if(n)
		Binary(n>>1);
	printf("%d",n&1);
}
void main()
{
	Binary(65);
}
