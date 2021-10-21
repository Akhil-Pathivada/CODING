/*
 Program to Check two strings are Anagrams or not....
 
 Time Complexity: O(N * log(N)) ..... MERGE SORT 
 Space Complexity : O(1)
*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void Swap(char *p, char *q) {

	char temp = *p;
	*p = *q;
	*q = temp;
}

int compareTo(const void *a, const void *b) {

	return (*(char*)a - *(char*)b);
}

int checkAnagrams(char *str1, char *str2) {

	if(strlen(str1) != strlen(str2)) {
		return 0;
	}
	return !strcmp(str1, str2);		
}

int main() {

	char str1[] = "ravindra";
	char str2[] = "aravindr";
	
	qsort(str1, strlen(str1), sizeof(*str1), compareTo);
	qsort(str2, strlen(str2), sizeof(*str2), compareTo);

	printf(checkAnagrams(str1, str2) ? "** ANAGRAMS **" : "** Not ANAGRAMS **");
}
