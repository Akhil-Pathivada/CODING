
// Passing Function name as an argument to other function.....

#include<stdio.h>

int func(int val)
{
	return ++val;
}

int dummyFunc( int (*fp)(int), int arg)
{
	return fp(arg);
}

void main()
{
	int num = dummyFunc(func,8);
	
	printf(" num = %d ", num);
}

// num = 9
