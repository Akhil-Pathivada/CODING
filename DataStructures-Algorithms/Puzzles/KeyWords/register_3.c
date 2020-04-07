// Understanding behaviour of 'register' variable

#include<stdio.h>

void main()
{
	register static int x = 10;
	
	printf("%d",x);
}

/*
error: multiple storage classes in declaration specifiers


Reason :
	Register is a storage class, and C doesn’t allow multiple storage class specifiers for a variable. So, register can not be used with static .

*/	
