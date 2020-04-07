/*
we want to test whether a value lies in the range 2 to 4 or 5 to 7.
Can we do it by using 'switch'?
*/

#include<stdio.h>

void main()
{
	int num = 3;
	
	switch(num)
	{
		case 2:
		case 3:
		case 4:
			printf("Exists between 2 to 4");
			break;
		case 5:
		case 6:
		case 7:
			printf("Exists between 5 to 7");
			break;
	}
}
