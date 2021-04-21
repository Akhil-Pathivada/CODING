// Check whether Kth bit is set or not.....
// Time Complexity :: O(logn)
#include<stdio.h>
void main()
{
	int k,num=68;
	printf("\nEnter K :: ");
	scanf("%d",&k);
	k=1<<(k-1);
	(num&k)?printf("\n SET \n"):printf("\n Not SET \n");
}
