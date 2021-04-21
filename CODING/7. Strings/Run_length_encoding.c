/*
Program for Run Length Encoding.....
Time Complexity :: O(n)
Space Complexity :: O(1)
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_LEN 100

char *runLengthEncoding(char *sourceStr)
{
	int count,j=0;

	int len = strlen(sourceStr);

	char *finalStr = (char*)malloc(sizeof(char)*(len*2+1));

	for(int index=0; index<len; index += count)
	{
		finalStr[j++] = sourceStr[index];

		count=1; 

		for(int i=index; i+1<len && sourceStr[i]==sourceStr[i+1] ;++count,++i);

		finalStr[j++] = count+48;
	}

	finalStr[j]='\0';

	return finalStr;
}

int main()
{
	char str[100];

	printf("Enter string :: ");
	scanf("%s", str);	

	printf("\n ** RESULT :: %s  **\n", runLengthEncoding(str));
}
