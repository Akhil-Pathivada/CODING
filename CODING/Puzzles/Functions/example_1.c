
#include<stdio.h>

void main()
{
	int a = 10;
	
	int func();
	
	a = func();
	
	printf(" %d ", a);
}

int func()
{
	printf("Hello World");
}

// Hello World 11 
