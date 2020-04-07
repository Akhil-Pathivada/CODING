// Program to copy one string into another

#include<stdio.h>

void strcopy(char *a,char *b)
{
	int i=0;
	while((a[i]=b[i++])!='\0');
}
int main()
{
	char sa[20],sb[]="RAVINDRA";
	strcopy(sa,sb);
	printf(" %s \n",sa);
}
