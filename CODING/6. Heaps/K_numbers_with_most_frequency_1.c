/*
Given an array of n numbers and a positive integer k. The problem is to find k numbers with most occurrences, i.e.,
the top k numbers having the maximum frequency. If two numbers have same frequency then the larger number should be
given preference. The numbers should be displayed in decreasing order of their frequencies. 
It is assumed that the array consists of k numbers with most occurrences.

d : number of distinct elements

Time Complexity : O(d * logd)
Space Complexity : O(d)
*/
#include<stdio.h>
#define MAX 20
#include<stdlib.h>

struct node
{
	int key, value;
};

int compareTo(const void *a,const void *b)
{
	struct node *n1 = (void*)a;
	
	struct node *n2 = (void*)b;
	
	if(n1->value == n2->value)
		return n1->key < n2->key;
	
	return n1->value < n2->value;
}

void KFrequentNumbers( int *arr, int n, int k)
{
	int hash[MAX] = {0};
	
	for(int i=0; i<n; ++i)
		hash[arr[i]]++;
	
	struct node *freqArr = (struct node*)malloc(sizeof(struct node) * MAX);
	
	for(int i=0; i<MAX; ++i)
	{
		freqArr[i].key = i;
		
		freqArr[i].value = hash[i];
	}
	
	qsort(freqArr, MAX, sizeof(struct node),compareTo);
	
	printf("Max. Frequency K elements are :  ");
	
	for(int i=0; i<k; ++i)
		printf("%d ", freqArr[i].key);
}

void main()
{	
    	int arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9}; 
    
    	int n = sizeof(arr) / sizeof(arr[0]); 
    
    	int k = 4; 
    
   	KFrequentNumbers(arr, n, k); 
}
