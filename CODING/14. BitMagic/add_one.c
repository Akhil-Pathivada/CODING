//Add one to the number without using '+' operator
#include<stdio.h>
int addOne(int n)
{
	int m=1;
	while(n&m)
	{
		n=n^m;
		m<<=1;
	}
	n=n^m;
	return n;
}
void main()
{
	int num;
	printf(" enter num  : ");
	scanf("%d",&num);
	printf(" after adding One to %d is :: %d \n",num,addOne(num));
}
