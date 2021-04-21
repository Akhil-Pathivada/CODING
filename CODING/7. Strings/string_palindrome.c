/*
 Check the String is PALINDROME or not
 Time Comnplexity :: O(n)
 Space Complexity :: O(1)
*/

#include<stdio.h>
#include<string.h>

int checkPalindrome(char *str,int start,int end)
{
	while(start<end)
	{
		if(str[start]!=str[end])
			return 0;
		start++;
		end--;
	}

	return 1;
}

void main()
{
	char str[100];

	printf("Enter the String : ");
	scanf("%s",str);

	checkPalindrome(str,0,strlen(str)-1) ? printf("\n** Palindrome **\n") : printf("\n** Not Palindrome **\n");
}

