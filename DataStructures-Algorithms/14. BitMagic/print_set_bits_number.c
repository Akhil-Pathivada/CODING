//Given a positive integer n. The problem is to print numbers in the range 1 to n having first and last bits as the only set bits.
//Time Complexity :: O(n)
#include<stdio.h>
int checkPowerOfTwo(int num)
{
	return !(num&(num-1));
}
void main()
{
	int n;
	printf(" Enter N : ");
	scanf("%d",&n);
	printf("Numbers : %d,",1);
	for(int i=3;i<n;i++)
	{
		if(checkPowerOfTwo(i-1))
			printf(" %d,",i);
	}
}
