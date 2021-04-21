// Toggle Kth bit of a number.....
// Time Complexity :: O(logn)
#include<stdio.h>
void main()
{
	int k,num=68;
	printf("\nEnter K :: ");
	scanf("%d",&k);
	k=1<<(k-1);
	num=num^k;
	printf("\n NUMBER : %d\n",num);
}
