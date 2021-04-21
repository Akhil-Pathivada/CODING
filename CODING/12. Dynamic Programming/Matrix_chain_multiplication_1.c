/*
Given a sequence of matrices, find the most efficient way to multiply these matrices together.
The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.

(Naive approach)

Time Complexity : O(2^n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<limits.h>

int getMinMultiplications( int p[], int i, int j)
{
	if(i==j)
		return 0;

	int count, min = INT_MAX;
	
	for(int k=i; k<j; ++k)
	{
		count = getMinMultiplications(p,i,k) + getMinMultiplications(p,k+1,j) + p[i-1]*p[k]*p[j] ;

		if(count < min)
			min = count;
	}
	
	return min;
}

void main()
{
	int arr[] = {1,2,3,4,3};
	
	int n = sizeof(arr)/sizeof(*arr);
	
	printf(" Min. multiplications needed : %d ", getMinMultiplications(arr,1,n-1));
}
