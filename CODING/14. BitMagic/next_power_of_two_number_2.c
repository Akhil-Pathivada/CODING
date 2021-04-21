// Get the next highest number which is a power of two .....
// Time Complexity :: O(logn)
#include<stdio.h>
void main()
{
	int num,temp=1,count=0;
	printf("\n enter a number : ");
	scanf("%d",&num);
	for( ;num; num>>=1,count++);
	for( ;count; temp<<=1,count--);
	printf("\n next highest number power of two :: %d \n",temp);
}
