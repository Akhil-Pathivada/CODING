
#include<stdio.h>

void main()
{
	int i = 1;
	
	while(i<=5)
	{
		printf(" %d,", i);
		
		if(i>2)
			goto here;
	}
}

void func()
{
	here:
		printf("\nif it works don't fix it");
}

/*
Error : 
	Goto cannot take control to a different function....	
*/
