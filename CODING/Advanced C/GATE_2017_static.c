#include<stdio.h>
int total(int v) 
{
	static int count = 0;
	while(v)
	{
		count += v&1;
		v >>= 1;
	}
	return count;
}
void main()
{
	static int x=0;
	int i=5;
	for(; i>0; i--)
	{
		x = x + total(i);
	}
	printf("%d\n", x);
}
// 23 
