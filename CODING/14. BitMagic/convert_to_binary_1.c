// Convert a Decimal to Binary Number

#include<stdio.h>
void Binary(int n)
{
	if(n)
		Binary(n/2);
	printf("%d",n%2);
}
void main()
{
	Binary(65);
}
