/*Write an Efficient C Program to Reverse Bits of a Number

Time Complexity : O(logn)
*/

#include<stdio.h>
#include<math.h>
int reverseBits(int n)
{
	int res=0;
	while(n)
	{
		res<<=1;
		if(n&1)
			res^=1;
		n>>=1;
	}
	return res;	
}

void main()
{
	printf(" After Reversing : %d \n",reverseBits(25));
}
