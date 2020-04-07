
// Passing Function name as an argument to other function.....

#include<stdio.h>

void Swap(int *a,int *b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

typedef void (*FuncPointer)(int*, int*);

void dummyFunc( FuncPointer fp, int *a,int *b)
{
	fp(a,b);
}

void main()
{
	int a = 10;
	int b = 20;
	
	dummyFunc(Swap,&a,&b);
	
	printf(" a: %d , b: %d ", a, b);
}

//  a: 20 , b: 10
