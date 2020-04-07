// Check whether thr give number is power of 4 or not....
//Time Complexity :: O(logn)
#include<stdio.h>
void main()
{
	int num,shifts=0,set_bits=0;
	printf(" enter the number : ");
	scanf("%d",&num);
	for( ;num;num>>=1)
	{
		set_bits=(num%2)?set_bits+1:set_bits;
		shifts++;
	}
	((shifts%2)&&(set_bits==1)) ? printf(" YES \n"):printf(" NO \n");
}
