/*
Program to remove duplicates in a String....

Time Complexity : O(N ^ 2)
Space Complexity : O(N)
*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define TOTAL_CHARS 256

char* removeDuplicates(char *sourceStr) {

	int len = strlen(sourceStr);
	char *finalStr = (char*)malloc(sizeof(char)*(len + 1)); // O(n)
	
	*finalStr = *sourceStr;
	int finalIndex = 1;
	
	for(int i = 1; sourceStr[i] != '\0'; ++i) {

		int flag = 0;
		
		for(int j = 0 ;finalStr[j] != '\0'; ++j) {

			if(sourceStr[i] == finalStr[j]) {
				flag = 1;
			}
		}
		
		if(!flag) {
			finalStr[finalIndex++] = sourceStr[i];
		}
	}
	finalStr[finalIndex] = '\0';
	
	return finalStr;
}

int main() {

	char str[] = "ravindraravi";
	
	puts(removeDuplicates(str));
} 
