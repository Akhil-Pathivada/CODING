/*
 C program to print a string without   quote in the program.
  
A token passed to macro can be converted to a string literal by using # before it.

*/
#include<stdio.h>
#define Get(x) #x

void main()
{
	printf(Get(GEEK));
}
