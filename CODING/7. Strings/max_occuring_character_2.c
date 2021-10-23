/*
Program to get the Maximum occuring character in the String....(Hash Approach)
Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>
#define COUNT 256

char getMaxChar(char *str) {
	
	int hash[COUNT] = {0}, max_count = -9999;
	char curr_char, max_char;

	for(int i = 0; str[i]; ++i) {
		hash[str[i]]++;
	}

	for(int i = 0; str[i]; ++i) {

		if(hash[str[i]] > max_count) {

			max_count = hash[str[i]];
			max_char = str[i];
		}
	}
	return max_char;
}

int main() {

	char str[] = "RAVINDRAAA";

	printf("**Maximum Occuring character : %c ", getMaxChar(str));
}
