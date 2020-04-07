
#include<stdio.h>

void main()
{
	float *p1, i = 25.50;
	
	char *p2;
	
	p1 = &i;
	
	p2 = (char*)&i;
	
	printf(" %f, %f ", *p1, *((float*)p2));	
}
