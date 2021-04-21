// Count number of set bits in a number.....
// Time Complexity :: O(logn)
#include<stdio.h>
void main()
{
	int num,count=0;
	printf("\n enter a number : ");
	scanf("%d",&num);
	while(num)
	{
		count=(num%2)?count+1:count;
		num/=2;
	}
	printf("\n no. of set bits  : %d \n",count);
}
