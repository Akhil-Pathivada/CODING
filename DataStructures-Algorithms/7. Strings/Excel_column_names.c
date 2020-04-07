//Get the excel column names for the numbers......

#include<stdio.h>
#include<string.h>

void Reverse( char *string, int begin, int end)
{
	while(begin<end)
	{
		char temp=string[begin];

		string[begin++]=string[end];

		string[end--]=temp;
	}
}

char* convertExcel(int number)
{
	int i=0,rem;

	char str[100];

	for( ;number>0 ;number/=26)
	{
		int rem = number%26;

		str[i++] = !rem ? 'Z' : (rem-1)+'A';
	}

	str[i]='\0';

	Reverse(str,0,strlen(str)-1);

	printf("\n** Excel Name :: %s **\n",str);
}

void main()
{
	int num;

	printf("Enter a Number : ");
	scanf("%d",&num);

	convertExcel(num);
}
