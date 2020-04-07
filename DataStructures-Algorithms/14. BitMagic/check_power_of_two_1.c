// Check whether number is Power of two or not.....
// Time Complexity :: O(logn)
#include<stdio.h>
void main()
{
	int num,count=0;
	printf("\n enter a number : ");
	scanf("%d",&num);
	while(num)
	{
		count=(num&1)?count+1:count;
		num>>=1;
	}
	count==1 ? printf("\n YES \n") : printf("\n NO \n");
}
