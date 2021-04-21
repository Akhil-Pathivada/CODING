// Multiply the number with '7' without using '*' operator
// Time Complexity :: O(logn)
#include<stdio.h>
void main()
{
	int num,temp;
	printf(" enter a number :: ");
	scanf("%d",&num);
	temp=num<<3;
	num=temp-num;
	printf(" RESULT : %d \n",num);
}
