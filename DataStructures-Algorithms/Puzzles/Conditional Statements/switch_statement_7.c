
// Applying switch statements on strings...

#include<stdio.h>

void main()
{
	char str[] = "abc";
	
	switch(str)
	{
		case "abc":
			printf("case - abc");
			break;
		default:
			printf("default ");
	}
}

/*
error: case label does not reduce to an integer constant
   case "abc":

Switch statements can only be executed on interger constants or constant expressions....
*/
