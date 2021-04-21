/*
Program to remove duplicates in a String....

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define TOTAL_CHARS 256

char* removeDuplicates(char *str)
{
	char hash_table[TOTAL_CHARS] = {0};
	
	int currentIndex = 0, finalIndex = 0;
	
	for( ; str[currentIndex] != '\0'; ++currentIndex)
	{
	 	char temp = str[currentIndex];
	 	
		if(hash_table[temp] == 0)
		{
			hash_table[temp] = 1;
			
			str[finalIndex++] = temp;
		}
	}
	
	str[finalIndex] = '\0';
	
	return str;
}

void main()
{
	char str[] = "ravindraravi";
	
	puts(removeDuplicates(str));
} 
