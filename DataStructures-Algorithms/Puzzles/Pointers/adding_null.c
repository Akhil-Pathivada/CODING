
#include "stdio.h"

void main()
{
	int a ,b = 5;
	
	a = b + NULL; /* Error */
	
	a = b + '\0'; /* prints '5' */
}
