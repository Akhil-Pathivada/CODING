/*
 Program to Check two strings are Anagrams or not....
 
Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define TOTAL_CHARS 256

int HashTable[TOTAL_CHARS]={0};

int checkAnagrams(char *str1,char *str2)
{
	if(strlen(str1)!=strlen(str2))
		return 0;

	while(*str1)
		HashTable[*str1++]++;

	while(*str2)
		HashTable[*str2++]--;

	for(int index=0 ;index<TOTAL_CHARS; index++)
	{
		if(HashTable[index]!=0)
			return 0;
	}

	return 1;		
}

void main()
{
	char str1[] = "ravindra";
	
	char str2[] = "aravindr";

	checkAnagrams(str1,str2) ? printf("\n** ANAGRAMS **\n") : printf("\n** Not ANAGRAMS **\n");
}
