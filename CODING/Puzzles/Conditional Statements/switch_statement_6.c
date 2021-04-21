
#include<stdio.h>

void main()
{
	int i = 2;
	
	switch(i)
	{
		printf(" Hello World....");
		
		case 1:
			printf("case-1");
			break;
		case 2:
			printf("case-2");
			break;
	}
}

/*
warning: statement will never be executed [-Wswitch-unreachable]
   printf(" Hello World....");
   
All the statements in a switch have to belong to some case or the other....
*/
