// Check whether a number is Sparse or not.....
// Sparse :: no consecutive ones are present in a Binary Number.....
//Time Compexity :: O(logn)
#include<stdio.h>
void main()
{
	int num;
	printf(" enter number : ");
	scanf("%d",&num);
	(num&(num<<1)) ? printf(" not SPARSE Number\n"): printf(" SPARSE Number\n");
}

 
