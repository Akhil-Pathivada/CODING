
#include<stdio.h>

void main()
{
	int i = 2, j = 2;
	
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

/*
Error:
	Constant expression is needed in second case, we cannot use 'j'	
*/
