/*
 Precedence of '*' and 'unary' operators
 These have Right Associativity
*/
#include<stdio.h>
#include<stdlib.h>
void main()
{
	int num=4;
	int *ptr=&num;
	printf(" ++*ptr = %d \n",++*ptr);
	printf(" *++ptr = %d \n",*++ptr);
	ptr=&num;
	printf(" *ptr++ = %d \n",*ptr++);// same as (*ptr)++
	
}
