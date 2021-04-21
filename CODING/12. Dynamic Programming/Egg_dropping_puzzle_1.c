/*
Given K-floors and N-eggs,
Calculate the minimum number of trails to check floors, from which eggs should be dropped so that total number of trials are minimized. (in worst case)

(Brute-Force Method)

Time Complexity : O(k * 2^n)
Space Complexity : O(n*k)

*/

#include<stdio.h>
#include<limits.h>

#define max(a,b)  (a>b) ? a : b

int EDP( int n, int k)
{
	if(k==0 || k==1)
		return k;
	
	if(n==1)
		return k;
		
	int x, res, min = INT_MAX;	
		
	for(x=1; x<=k; ++x)
	{
		res = max(EDP(n-1,x-1), EDP(n,k-x));
		
		if(res < min)
			min = res;
	}
		
	return min + 1;	
}

void main()
{
	int n = 2; // eggs
	
	int k = 10; // floors
	
	printf(" No. of trials with %d Eggs and %d Floors is = %d ", n, k, EDP(n,k));
}



