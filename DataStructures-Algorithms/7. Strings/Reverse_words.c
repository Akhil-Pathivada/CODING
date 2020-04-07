/*
Reverse the words in a String

Time Complexity :: O(n)
Space Complexity :: O(1)
*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void Reverse(char *start,char *end)
{
	while(start < end)
	{
		int temp = *start;
		*start++ = *end;
		*end-- = temp;
	}
}

void ReverseWords(char *str)
{
	char *wordBegin,*temp;

	wordBegin=str;

	temp=str;

	while(*temp)
	{
		temp++;

		if((*temp==' ') || (*temp=='\0'))
		{
			Reverse(wordBegin,temp-1);

			wordBegin=temp+1;
		}
	}

	Reverse(str,temp-1);
}
void main()
{
	char str[]="I Love this Program very much";

	ReverseWords(str);

	printf(" RESULT :: ");
	puts(str);
}
