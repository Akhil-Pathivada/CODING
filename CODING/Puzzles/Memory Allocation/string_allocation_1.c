
#include<stdio.h>
#include<string.h>

void main()
{
	char *str;
	
	char *func();
	
	str = func();
	
	printf(" %s", str);
}

char* func()
{
	char buffer[60];
	
	strcpy(buffer, "RAM - Rarely Adequate Memory ");
	
	return buffer;
}

/*
 warning: function returns address of local variable [-Wreturn-local-addr]
  return buffer;
         ^~~~~~
*/         
