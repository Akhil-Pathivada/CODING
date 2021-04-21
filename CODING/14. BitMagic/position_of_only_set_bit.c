//Find position of the only set bit
// Time Complexity :: O(logn)
#include<stdio.h>
void main()
{
	int num,count=1;
	printf(" enter a number : ");
	scanf("%d",&num);
	if(num&(num-1))
	{	
		printf(" Given number is not a power of 2 \n"); // only number(power of 2) will contains only one 1.....
		return;
	}
	for( ;!(num%2);num/=2,count++);
	printf("\n position of only set bit :: %d \n",count);
}
