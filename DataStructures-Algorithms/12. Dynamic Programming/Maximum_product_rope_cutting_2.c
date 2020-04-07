/*
Given a rope of length n meters, cut the rope in different parts of integer lengths in a way that maximizes product of lengths of all parts. 
You must make at least one cut. Assume that the length of rope is more than 2 meters. 

(Dynamic Programming)

Time Complexity : O(n^2)
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
	int val[n+1];
	
	val[0] = val[1] = 0;
	
	int i,j;
	
	for(i=1; i<=n; ++i)
	{
		int maxVal = INT_MIN;
		
		for(j=1; j <= i/2; ++j)
			maxVal = max(maxVal, j*(i-j), j*val[i-j]);
			
		val[i] = maxVal;
	}
	
	return val[n]; 	
}

void main()
{
	int n = 10;

	printf(" Max. Product = %d ", maxProd(n));
}
