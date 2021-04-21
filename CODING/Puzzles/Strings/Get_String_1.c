#include<stdio.h>

char* getString()
{
	char str[] = "RAVINDRA";
	
	return str;
}

void main()
{
	printf("%s", getString());
}

/*

COMPILE ERROR:

function returns address of local variable [-Wreturn-local-addr]
  return str;

Because character array is local in the getString(), where the memory will be allocated in the Stack.....
*/
