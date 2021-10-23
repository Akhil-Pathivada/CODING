/* 
Program to reverse string

Time Complexity : O(N)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<string.h>

void swap(char *a, char *b) {

	char temp = *a;
	*a = *b;
	*b = temp;
}

char* reverse(char *str) {

	int n = strlen(str);	

	for(int i = 0; i < n/2; ++i) {
		swap(&str[i], &str[n - i - 1]); 
	}
	return str;
}

int main() {

	char str[] = "geeksforgeeks";

	printf("Reverse of the String : %s ", reverse(str));
}
