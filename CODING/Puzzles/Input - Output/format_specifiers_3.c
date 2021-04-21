
// Understanding %n format specifier

#include<stdio.h>

void main()
{
	int count;
	
	printf("Geeks for %nGeeks ",&count);
	
	printf("%d",count);
}

// Geeks for Geeks 10
