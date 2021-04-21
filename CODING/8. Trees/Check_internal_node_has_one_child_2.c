/*
Given Preorder traversal of a BST, check if each non-leaf node has only one child. 
Assume that the BST contains unique entries.

Time Complexity : O(n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

bool hasOnlyOneChild( int *pre, int n)
{
	int nextDiff, lastDiff;
	
	for(int i=0; i<n-1; ++i)
	{
		nextDiff = pre[i] - pre[i+1];
		
		lastDiff = pre[i] - pre[n-1];
		
		if(nextDiff * lastDiff < 0)
			return false;
	}
	
	return true;
}

void main()
{
	int pre[] = {8, 3, 5, 7, 6};
	
	int n = sizeof(pre)/sizeof(*pre);
	
	printf(hasOnlyOneChild(pre, n) ? "Yes" : "No");
}
