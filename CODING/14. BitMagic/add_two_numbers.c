//Add two numbers without using '+' operator.....

#include<stdio.h>
int getSum(int x,int y)
{
	if(!y)
		return x;
	return getSum(x^y,(x&y)<<1);
}
int main()
{
	printf(" SUM : %d \n",getSum(15,32));
}
