// Program to copy one string into another

#include<stdio.h>

void strcopy(char *a,char *b)
{
	while((*a++=*b++)!='\0');
}

int main()
{
	char sa[20],sb[]="RAVINDRA";
	strcopy(sa,sb);
	printf(" %s \n",sa);
}
