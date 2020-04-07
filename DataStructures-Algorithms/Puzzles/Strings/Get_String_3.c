
#include<stdio.h>
#include<stdlib.h>

char** getString()
{
	char *str = "RAVINDRA";
	
	return &str;
}

void main()
{
	char **sptr = getString();
}

/*

COMPILE ERROR:
 warning: function returns address of local variable [-Wreturn-local-addr]
  return &str;

Because, str is a pointer in the Stack, which is pointing to a address holding "RAVINDRA" located in the HEAP.
the address of 'str' will not be returned since it is local variable of getString() located in the STACK...

*/
