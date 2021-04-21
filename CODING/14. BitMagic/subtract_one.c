//subtract one from the number without using '-' operator
#include<stdio.h>
int subtractOne(int n)
{
	int m=1;
	while(!(n&m))
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
	printf(" after subtracting One from %d is :: %d \n",num,subtractOne(num));
}
