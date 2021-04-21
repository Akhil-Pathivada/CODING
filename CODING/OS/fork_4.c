#include<stdio.h>
#include <sys/types.h> 
#include <unistd.h>
void callFork()
{
	int x=1;
	if(fork()==0)
		printf("Child makes x=%d \n",++x);
	else
		printf("Parent makes x=%d \n",--x);
} 
void main()
{
	callFork();
}
/*
Parent makes x=0 
Child makes x=2 
(or)
Child makes x=2 
Parent makes x=0 
*/
