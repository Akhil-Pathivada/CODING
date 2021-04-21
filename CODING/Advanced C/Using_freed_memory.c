
// Using a memory which was already freed....

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void main()
{
	char *b = (char*)malloc(10);
	
	char *c = b;
	
	free(b);
	
	strcpy(c, "hello");
	
	printf(" C is  %s", c);
	
}

//  C is  hello.... But this should be an Error, based on Compiler
