#include<stdio.h>
#include<string.h>

char* reverse(char *str)
{
	char temp;
	for(int i=0,j=strlen(str)-1 ;i<j; i++,j--)
	{
		temp=str[i];
		str[i]=str[j];
		str[j]=temp;
	}
	return str;
}

void main()
{
	char str[100];
	printf("Enter the string : ");
	scanf("%s",str);
	printf("\n** Reverse of the String : %s **\n",reverse(str));
}
