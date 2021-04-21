// Understanding behaviour of 'register' variable

#include<stdio.h>

register int x;

void main()
{
	x = 10;
	
	printf("%d",x);
}

/*
error: register name not specified for ‘x’ 


Reason :
	Register can only be used within a block (local), it can not be used in the global scope (outside main).

*/	
