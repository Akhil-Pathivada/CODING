/*
 Program to find the first non-repeating character in a String....
 Time Complexity :: O(n)
 Space Complexity :: O(1)
*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define TOTAL_CHARS 256

int getFirstNonRepeatingChar(char *str)
{
	int i,hash_table[TOTAL_CHARS]={0};

	for(i=0;str[i];i++)
		hash_table[str[i]]++;

	for(i=0;str[i] && hash_table[str[i]]>1;i++);

	return i;
}

void main()
{
	char str[100];

	printf("\nEnter the String : ");
	scanf("%s",str);

	int index=getFirstNonRepeatingChar(str);

	if(index==strlen(str))
		printf("\n ** no non-repeating characters are found **\n");
	else
		printf("\n** first non-repeating character : %c **\n",str[index]);
} 
