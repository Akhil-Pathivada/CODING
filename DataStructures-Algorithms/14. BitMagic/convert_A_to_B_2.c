#include<stdio.h>

int countFlipBits(int A,int B)
{
	int num=A^B;
	int count=0;

	for( ;num; num>>=1)
		count = (num&1) ? count+1 : count;

	return count;
}

void main()
{
	int A,B;

	printf("enter A,B : ");
	scanf("%d%d",&A,&B);

	printf("\nNo. of bits to be flipped :: %d \n",countFlipBits(A,B));
}
