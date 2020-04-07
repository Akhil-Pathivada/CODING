// Program to find the longest consecutive ones in a Binary Number.....
//Time Complexity :: O(logn)
/*
So the operation x = (x & (x << 1)) reduces length of every sequence of 1s by one in binary representation of x.
If we keep doing this operation in a loop, we end up with x = 0.
The number of iterations required to reach 0 is actually length of the longest consecutive sequence of 1s.
*/
#include<stdio.h>
void main()
{
	int num,count=0;
	printf(" enter number : ");
	scanf("%d",&num);
	while(num)
	{
		num=num&(num<<1);
		count++;
	}
	printf(" Longest consecutive ones : %d \n",count);
}
