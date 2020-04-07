#include<stdio.h>
#include <sys/types.h> 
#include <unistd.h> 
void main()
{
	fork();
	fork();
	fork();
	printf("hello world\n");
}
/*
hello world
hello world
hello world
hello world
hello world
hello world
hello world
hello world
*/
