// Deletion in Trie

#include<stdio.h>
#define SIZE 26
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>

#define CHAR_TO_INDEX(ch) ((int)ch - (int)'a') 

struct node {

	struct node *alphabet[SIZE];
	bool isEnd;
};

struct node *newNode() {

	struct node *nn = (struct node*)malloc(sizeof(struct node));
	
	for(int i = 0; i < SIZE; ++i) {

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
		
		if(!ptr->alphabet[index])
			return false;
		
		ptr = ptr->alphabet[index];
	}
	return ptr->isEnd;	
}

bool isEmpty(struct node *root) {

	for(int i = 0; i < SIZE; ++i) {

		if(root->alphabet[i]) {

			return false;
			
		}
	}
	return true;
}

struct node *Delete(struct node *root, char *str, int i, int n) {

	if(!root) {

		return NULL; 
	}
	
	if(i == n) {

		if(root->isEnd) {

			root->isEnd = false;
		}
		
		if(isEmpty(root)) {

			free(root);
			root = NULL;	
		}
		return root;	
	}

	int index = CHAR_TO_INDEX(str[i]);

	root->alphabet[index] = Delete(root->alphabet[index], str, ++i, n);
	
	if(isEmpty(root) && !root->isEnd) {

		free(root);
		root = NULL;
	}
	return root;
}

int main() {

	char keys[][8] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};

	struct node *root = newNode(); 
	
	int n = sizeof(keys) / sizeof(*keys);
	
	// Construct Trie
	for(int i = 0; i < n; ++i) {

		insertKeys(root, keys[i]); 
	}
		
	Delete(root, "answer", 0, strlen("answer"));

	printf(search(root, "answer") ? "Found in trie" : "Not found in trie");
}
