// Program for 'pointer to functions'

#include<stdio.h>

int Sum(int a,int b)
{
	return a+b;
}

int main()
{
	int (*fp1)(int ,int );
	
	int (*fp2)(int ,int );

	fp1 = &Sum;
	fp2 = Sum;
	printf("sum = %d \n",fp1(5,6));
	printf("sum = %d \n",fp2(5,6));
}
