
// Freeing up a memory which was already freed..

#include<stdio.h>
#include<stdlib.h>

void main()
{
	char *str;
	
	str =  (char*)malloc(10);
	
	free(str);
	free(str);
	
	printf("Hello World");
}

// executes fine....
