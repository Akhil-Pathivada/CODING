
#include<stdio.h>

void main()
{
	int i = 1;
	
	for( ; ; )
	{
		printf(" %d,", i++);
		if(i>10)
			break;
	}
}
