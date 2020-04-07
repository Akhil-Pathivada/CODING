// Converting an Integer into String......
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
char* convert(int num,char *str)
{
	int sign,i=0;
	if((sign=num)<0)
		num=-num;
	do
	{
		str[i++]=num%10+'0'; //converting into ASCII
	}while((num/=10)>0);
	if(sign<0)
		str[i++]='-';
	str[i]='\0';
	return reverse(str);
}
void main()
{
	int num;
	char str[100];
	printf("\nEnter the number : ");
	scanf("%d",&num);
	printf("** Converted String :: %s **\n",convert(num,str));
}
