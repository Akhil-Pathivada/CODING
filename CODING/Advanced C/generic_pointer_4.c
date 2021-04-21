// Generic Pointers as Function Arguments.....

#include<stdio.h>
#include<stdlib.h>

void Swap(void *a,void *b)
{
	int temp=*(int*)a;
	*(int*)a=*(int*)b;
	*(int*)b=temp;
}
void main()
{
	int a=14,b=25;
	Swap(&a,&b);
	printf(" a: %d, b:%d ",a,b);
}
