
#include<stdio.h>

void main()
{
	extern int i; 
	
	printf(" %d", i);
}
int a = 20;


/*
Output : error
 	 undefined reference to `i'

Because, variable 'i' is just declared in the main(), but not defined....
*/
