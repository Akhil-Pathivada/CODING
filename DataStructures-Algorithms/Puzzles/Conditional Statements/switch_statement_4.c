
#include<stdio.h>

void main()
{
	int i = 6;
	
	switch(i)
	{
		case 1:
			printf("case-constant");
			break;
		case 1*2+4:
			printf("case-expression");
			break;
	}
}

// case-expression
