/*
 Program to find the first non-repeating character in a String....
 Time Complexity :: O(n)
 Space Complexity :: O(1)
*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<limits.h>

#define TOTAL_CHARS 256

struct countChar {

	int index;
	int count;
};

struct countChar* getHashCount(char *str) {

	struct countChar *hash_table = (struct countChar*)malloc(sizeof(TOTAL_CHARS));

	for(int i = 0; str[i]; ++i) { // O(N)

		(hash_table[str[i]].count)++;
		hash_table[str[i]].index = i;
	}
	return hash_table;	
}

int getFirstNonRepeatingChar(char *str) {

	struct countChar *hash_table = getHashCount(str);

	int min = INT_MAX;

	for(int i = 0; i < TOTAL_CHARS; ++i) { // constant loop

		int temp_index = hash_table[i].index;
		if(hash_table[i].count == 1 && temp_index < min)
			min = temp_index;
	}
	return min;
}

int main() {

	char str[100];

	printf("Enter the String: ");
	scanf("%s", str);

	int index = getFirstNonRepeatingChar(str);

	if(index == INT_MAX)
		printf("** no non-repeating characters are found **");
	else
		printf("** first non-repeating character : %c **", str[index]);
} 
