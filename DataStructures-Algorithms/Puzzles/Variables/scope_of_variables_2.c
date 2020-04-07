
#include<stdio.h>

void main()
{
	int x = 40;
	{
		int x = 20;
	
		printf(" %d", x);
	}
	printf(" %d", x);
}

// 20, 40
