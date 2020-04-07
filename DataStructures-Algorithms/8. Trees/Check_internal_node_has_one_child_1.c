/*
Given Preorder traversal of a BST, check if each non-leaf node has only one child. 
Assume that the BST contains unique entries.

Time Complexity : O(n^2)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

bool hasOnlyOneChild( int *pre, int n)
{
	for(int i=0; i<n-1; ++i)
	{
		int j = i+1;
		
		if(pre[j] < pre[i])
		{
			for( ; j<n; ++j)
			{
				if(pre[j] > pre[i])
					return false;
			}
		}
		
		else
		{
			for( ; j<n; ++j)
			{
				if(pre[j] < pre[i])
					return false;
			}
		}
	}
	
	return true;
}

void main()
{
	int pre[] = {8, 3, 5, 7, 6};
	
	int n = sizeof(pre)/sizeof(*pre);
	
	printf(hasOnlyOneChild(pre, n) ? "Yes" : "No");
}
