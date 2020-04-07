// Check if two numbers are equal or not
#include<stdio.h>
int checkEqual(int a,int b)
{
	if(a & ~b)
		return printf(" Not Same");
	return printf(" Same");
}
int main()
{
	checkEqual(10,10);
}
