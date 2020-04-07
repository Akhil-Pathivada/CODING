/*
Program to check whether two strings are rotations of each other or not......
Time Complexity :: O(n^2)
Space Complexity :: O(1)
*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define MAX_LEN 50

char *makeRotation(char *str)
{
	char temp=*str;

	int i=0;

	for( ;str[i+1];i++)
		str[i]=str[i+1];

	str[i]=temp;

	return str;	
}

int checkRotations(char *str1,char *str2)
{
	int len1=strlen(str1);

	int len2=strlen(str2);

	if(len1!=len2)
		return 0;

	if(strcmp(str1,str2)==0)
		return 1;

	for(int k=0 ;k<len1;k++)
	{
		char *temp_str=makeRotation(str2);

		if(strcmp(str1,temp_str)==0)
			return 1;
	}

	return 0;
}

void main()
{
	char str1[MAX_LEN], str2[MAX_LEN];

	printf("Enter String 1 :: ");
	scanf("%s",str1);

	printf("\nEnter String 2 :: ");
	scanf("%s",str2);

	checkRotations(str1,str2) ? printf("\n ** Strings are identical **\n") : printf("\n ** Strings are not identical **\n");
}
