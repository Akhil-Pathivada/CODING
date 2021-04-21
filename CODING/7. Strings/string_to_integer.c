// Converting a String into Integer......
#include<stdio.h>
#include<string.h>
int convert(char *str)
{
	int num=0,i=0;
	for(i=0; str[i]>='0' && str[i]<='9'; i++)
		num=num*10+(str[i]-'0');
	return num;
}
void main()
{
	char str[100];
	printf("\nEnter the string : ");
	scanf("%s",str);
	printf("** Converted Number :: %d **\n",convert(str));
}
