
// Solution to the previous problem..... Solution 1

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
	static char buffer[60];
	
	strcpy(buffer, "RAM - Rarely Adequate Memory ");
	
	return buffer;
}

//  RAM - Rarely Adequate Memory 
