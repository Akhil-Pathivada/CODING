//Get the excel column numbers for the names......

#include<stdio.h>
#include<string.h>

char* convertExcel(char *str)
{
	int num=0,i=0;

	for( ;*str ;str++)

		num=(num*26)+(*str-'A')+1;

	printf("\n** Excel Number :: %d **\n",num);
}

void main()
{
	char str[10];

	printf("Enter a name : ");
	scanf("%s",str);

	convertExcel(str);
}
