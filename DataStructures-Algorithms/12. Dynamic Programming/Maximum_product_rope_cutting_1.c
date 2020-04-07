/*
Given a rope of length n meters, cut the rope in different parts of integer lengths in a way that maximizes product of lengths of all parts. 
You must make at least one cut. Assume that the length of rope is more than 2 meters. 

(Brute-Force Method)

Time Complexity : O(n^n)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<limits.h>

int max(int a,int b,int c)
{
	return (a>b) ? ( a>c ? a : c ) : ( b>c ? b : c);  
}

int maxProd(int n)
{
	if(n==0 || n==1)
		return 0;
		
	int maxVal = INT_MIN;
	
	for(int i=1; i<n; ++i)
		maxVal = max(maxVal, i*(n-i), maxProd(n-i)*i);
	
	return maxVal;
}

void main()
{
	int n = 10;

	printf(" Max. Product = %d ", maxProd(n));
}
