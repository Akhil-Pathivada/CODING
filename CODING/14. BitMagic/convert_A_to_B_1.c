/*
Count number of bits to be flipped to convert A to B 
Time Complexity : O(logn)
*/
#include<stdio.h>

int countFlipBits(int A,int B)
{
	int count=0;
	while(A||B)
	{
		
		count = !((A&1)==(B&1)) ? count+1 : count;

		A>>=1;
		B>>=1;
	}
	return count;
}

void main()
{
	int A,B;

	printf("enter A,B : ");
	scanf("%d%d",&A,&B);

	printf("Total bits to be flipped :: %d\n",countFlipBits(A,B));
}
