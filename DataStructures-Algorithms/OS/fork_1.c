#include<stdio.h>
#include <sys/types.h> 
#include <unistd.h> 
void main()
{
	fork();
	printf("hello world\n");
}
/*
hello world
hello world
*/
