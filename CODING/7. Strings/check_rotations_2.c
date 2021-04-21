/*
Program to check whether two strings are rotations of each other or not......
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define MAX_LEN 50

int checkRotations(char *str1,char *str2)
{
	int len1=strlen(str1);

	int len2=strlen(str2);

	if(len1!=len2)
		return 0;

	char *temp_str = (char*)malloc(sizeof(char)*(len1*2+1));

	*temp_str='\0';

	strcat(temp_str,str1);

	strcat(temp_str,str1);

	char *ptr = strstr(temp_str,str2);

	free(temp_str);

	return ptr ? 1 : 0;
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
