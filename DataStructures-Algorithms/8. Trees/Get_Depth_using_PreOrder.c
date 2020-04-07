/*
Program to get the Depth of Full Binary Tree, if PreOrder is given as String

Time Complexity : 
Space Complexity : 
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int max( int a, int b)
{
	return a > b ? a : b;
}

struct node
{
	int data;
	struct node *left, *right;
};

int getDepth( char *str, int index, int len)
{
	if(index >= len || str[index] == 'l')
		return 0;

	return 1 + max(getDepth(str, index+1, len), getDepth(str, index+2, len));
}

int main()
{
	char str[] = "nlnnlll";

	printf("Depth of Binary Tree = %d ", getDepth(str, 0, strlen(str)));
}			