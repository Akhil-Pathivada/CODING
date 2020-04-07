#include<stdio.h>
#include<string.h>
void main()
{
	char str[100];

	printf("Enter the string : ");
	scanf("%s",str);

	printf("\n** Reverse of the String : %s **\n",strrev(str));
}
