
// Solution to the previous problem..... Solution 2

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void main()
{
	char *str;
	
	char *func();
	
	str = func();
	
	printf(" %s", str);
}

char* func()
{	
	char *buffer;
	
	buffer = (char*)malloc(sizeof(char) * 60);
	
	strcpy(buffer, "RAM - Rarely Adequate Memory ");
	
	return buffer;
}

//  RAM - Rarely Adequate Memory 
