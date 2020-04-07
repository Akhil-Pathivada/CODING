/*
 Alpha_Numeric Palindrome check.... 
Consider alphabets and numbers only for palindrome check. Ignore symbols and whitespaces.
Time Complexity :: O(n)
*/
#include<stdio.h>
#include<string.h>
#include<ctype.h>

void checkSpecialChar(char a,char b,int *s,int *e)
{
	if(!isalnum(a))
		++*s;

	if(!isalnum(b))
		--*e;
}

int checkEqualChar(char a,char b)
{
	return tolower(a)==tolower(b);
}

int checkPalindrome(char *str)
{
	int start=0,end=strlen(str)-1;

	while(start<end)
	{
		char a=str[start],b=str[end];

		if(!isalnum(a) || !isalnum(b))
			checkSpecialChar(a,b,&start,&end);
		else
		{
			if(!checkEqualChar(a,b))
				return 0;
			start++;
			end--;
		}
	}
	return 1;
}

void main()
{
	char str[]="I am :IronnorI Ma, i";

	checkPalindrome(str) ? printf(" PALINDROME\n"):printf(" NOT PALINDROME\n");
}
