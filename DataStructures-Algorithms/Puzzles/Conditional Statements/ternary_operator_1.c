
#include<stdio.h>

void main()
{
	int a = 10, b;
	
	a >= 5 ? b=100 : b=200; 
	
	/* Correct Statement
	a >=5 ? b=100 : (b=200); */
}

/*
error: lvalue required as left operand of assignment
  a >= 5 ? b=100 : b=200;
                    ^
*/
