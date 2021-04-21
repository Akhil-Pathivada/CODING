//Count total set bits from 1 to n....
//Time Complexity :: O(n*logn)
//Space Complexity :: O(1)
#include<stdio.h>
int countSetBits(int n)
{
	static int count=0;
	for(int i=1;i<=n;i++)
	{
		while(i) // O(logn)
		{
			count=(i&1)?count+1:count;
			i>>=1;
		}
	}
	return count;
}
void main()
{
	int n;
	printf("enter n : ");
	scanf("%d",&n);
	printf("Total SET bits from 1 to %d is :: %d \n",n,countSetBits(n));
}
