/*
 A simple function has to be written in which returns 1 if 0 is passed to it and 0 if 1 is passed to it.
 The condition was only to use mathematical operations like +, -, %, *, / and no conditional statements were allowed.
*/

#include<stdio.h>

int getValue(int x)
{
	return (x+1)%2;
}

void main()
{
	printf(" %d ",getValue(1));
	printf(" %d ",getValue(0));
}
