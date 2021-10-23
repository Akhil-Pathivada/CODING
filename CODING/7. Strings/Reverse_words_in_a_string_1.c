/*
Reverse the words in a String

Time Complexity : O(N)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void reverse(char *start, char *end) {

	while(start < end) {

		int temp = *start;
		*start++ = *end;
		*end-- = temp;
	}
}

void reverseWords(char *str) {

	char *wordBegin = str;
	char *temp = str;

	while(*temp) {

		++temp;

		if((*temp == ' ') || (*temp == '\0')) {

			reverse(wordBegin, temp - 1);
			wordBegin = temp + 1;
		}
	}
	reverse(str, temp - 1);
}
int main() {

	char str[] = "I Love this Program very much";

	reverseWords(str);
	puts(str);
}
