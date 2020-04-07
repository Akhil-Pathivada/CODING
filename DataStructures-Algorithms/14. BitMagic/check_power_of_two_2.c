// Check whether number is Power of two or not.....
// Time Complexity :: O(1)
#include<stdio.h>
void main()
{
	int num;
	printf("\n enter a number : ");
	scanf("%d",&num);
	!(num&(num-1))? printf("\n YES \n") : printf("\n NO \n");
}
