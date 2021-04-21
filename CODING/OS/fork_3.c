#include<stdio.h>
#include <sys/types.h> 
#include <unistd.h>
void callFork()
{
	if(fork()==0)
		printf("hello from Child\n");
	else
		printf("hello from Parent\n");
} 
void main()
{
	callFork();
}
/*
hello from Parent
hello from Child
(or)
hello from Child
hello from Parent
*/
