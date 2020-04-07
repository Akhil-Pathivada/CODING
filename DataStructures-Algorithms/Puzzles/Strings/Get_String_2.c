
#include<stdio.h>
#include<stdlib.h>

char* getString()
{
	char *str = "RAVINDRA";
	
	return str;
}

void main()
{
	printf("%s", getString());
}

/*
Executes fine....

Because, memory to the pointers (malloc) will be allocated in the HEAP ,not in the STACK

*/
