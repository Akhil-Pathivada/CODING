// Find letter’s position in Alphabet using Bit operation
//Time Complexity :: O(n)
// Space Complexity :: O(1)
#include<stdio.h>
void getPositions(char *str)
{
	for( ;*str;str++)
	{
		int pos=(*str)&31;
		printf(" %d,",pos);
	}
}
int main()
{
	char str[]="GEEKSFORGEEKS";
	getPositions(str);
}
