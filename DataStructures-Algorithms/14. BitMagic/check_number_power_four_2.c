// Check whether thr give number is power of 4 or not....
//Time Complexity :: O(logn)
#include<stdio.h>
void main()
{
	int num;
	printf(" enter the number : ");
	scanf("%d",&num);
	while(num%4==0)
		num/=4;
	(num==1) ? printf(" YES \n"):printf(" NO \n");
}
