// Insertion and Search in Trie

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>

#define size 26
#define CHAR_TO_INDEX(ch) ((int)ch - (int)'a') 

struct node {

	struct node *alphabet[size];
	bool isEnd;
};

struct node *newNode() {

	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	for(int i = 0; i < size; ++i) {

		nn->alphabet[i] = NULL;
	}
	nn->isEnd = false;
	
	return nn;
}

void insertKeys(struct node *root, char *str) {

	int length = strlen(str);
	struct node *ptr = root;
	
	for(int i = 0; i < length; ++i) {

		int index = CHAR_TO_INDEX(str[i]);
		
		if(!ptr->alphabet[index]) {

			ptr->alphabet[index] = newNode();
		}
		ptr = ptr->alphabet[index];
	}
	ptr->isEnd = true;
}

bool search(struct node *root, char *str) {

	int n = strlen(str);
	struct node *ptr = root;	
	
	for(int i = 0; i < n; ++i) {

		int index = CHAR_TO_INDEX(str[i]);
		
		if(!ptr->alphabet[index]) {

			return false;
		}
		ptr = ptr->alphabet[index];
	}
	return ptr->isEnd;	
}

int main() {

	char keys[][8] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};

	struct node *root = newNode(); 
	
	int n = sizeof(keys) / sizeof(*keys);
	
	// Construct Trie
	for(int i = 0; i < n; ++i) {

		insertKeys(root, keys[i]);
	}

	printf(search(root, "answer") ? "Found in trie" : "Not found in trie");
}	
