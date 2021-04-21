
#include<stdio.h>
#define j 2

void main()
{
	int i = 2;
	
	switch(i)
	{
		case 1:
			printf("case-1");
			break;
		case j:
			printf("case-2");
			break;
	}
}

// case-2
