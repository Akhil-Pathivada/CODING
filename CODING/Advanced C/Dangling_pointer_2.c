/*
 Example on understanding of Dangling pointer.... 
 The pointer pointing to local variable becomes dangling when local variable is not static. 
*/

#include<stdio.h>

int *getAddress()
{
	static int x = 5;
	
	printf("Actual Address = %p ", &x);
	
	return &x;
}

void main()
{
	int *ptr = getAddress();
	
	printf(" Received Address = %p ", ptr);
}
