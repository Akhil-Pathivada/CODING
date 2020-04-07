// Get the next highest number which is a power of two .....
// Time Complexity :: O(logn)
#include<stdio.h>
#include<math.h>
void main()
{
	int num,count,temp=1;
	printf("\n enter a number : ");
	scanf("%d",&num);
	count=floor(log(num)+1);
	temp<<=count;
	printf("\n next highest number power of two :: %d \n",temp);
}
