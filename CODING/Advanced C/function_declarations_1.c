// Function declarations.....

#include<stdio.h>

void Max(x,y)
int x,y;
{
	(x>y) ? printf("%d",x) : printf("%d",y);
}

void Min(int x,int y)
{
	(x<y) ? printf("%d",x) : printf("%d",y);
}

void main()
{
	Max(2,3);

	Min(2,3);
}
