//Russian Peasant (Multiply two numbers using bitwise operators)
#include<stdio.h>
int Multiply(int a,int b)
{
	int res=0;
	while(b>0)
	{
		if(b&1)
			res+=a;
		a<<=1;
		b>>=1;
	}
	return res;
}
void main()
{
	int n1,n2;
	printf(" enter n1 && n2 : ");
	scanf("%d %d",&n1,&n2);
	printf(" product of %d,%d is :: %d \n",n1,n2,Multiply(n1,n2));
}
