/*
Write a function to count number of smaller elements on right of each element in an array. 
Given an unsorted array arr[] of distinct integers, construct another array countSmaller[] such that countSmaller[i] contains count of smaller elements on right side of each element arr[i] in array.

Input:   arr[] =  {12, 1, 2, 3, 0, 11, 4}
Output:  countSmaller[]  =  {6, 1, 1, 1, 0, 1, 0} 

Time Complexity : O(N * log(N))
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>

struct node {

	int data; // value of node
	int count; // count of its smaller nodes
	struct node *left, *right;
};

struct node* createNode(int data, int count) {

	struct node *nn = (struct node*)malloc(sizeof(struct node));
	nn->data = data;
	nn->count = count;
	nn->left = nn->right = NULL;

	return nn;
}

int insertNode(struct node **root, int value, int count) {

	if(!*root) {

		*root = createNode(value, 0);
		return count;
	}
	struct node *parent = *root;

	if(value > parent->data) {

		root->right = insertNode(root->right, value, count + 1);	
		return root->count + root->right->count;
	}
	else {
		parent->count++;
		return insertNode(&root->left, value, count);
	}
}

void computeCountSmallerArray(int *arr, int *countSmaller, int n) {

	// initialize root
	struct node *root = NULL;
	// = createNode(arr[n-1], 0);
	// countSmaller[n-1] = 0;

	// insert elements from backside into BST and then get countSmaller value
	for(int i = n - 1; i >=0 ; --i) {
		countSmaller[i] = insertNode(&root, arr[i], 0);	
	}
}

int main() {

	int arr[] = {12, 10, 5, 4, 2, 20, 6, 1, 0, 2};
	int n = sizeof(arr) / sizeof(arr[0]);
	int *countSmaller = (int*)malloc(sizeof(int) * n); // store results in array

	computeCountSmallerArray(arr, countSmaller, n);

	for(int i = 0; i < n; ++i) {
		printf("%d, ", countSmaller[i]);
	}
}