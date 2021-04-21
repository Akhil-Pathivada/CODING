/*
Given K-floors and N-eggs,
Calculate the minimum number of trails to check floors, from which eggs should be dropped so that total number of trials are minimized. (in worst case)

(Dynamic Programming)

Time Complexity : O(n * k^2)
Space Complexity : O(n*k)
*/

#include<stdio.h>
#include<limits.h>

int max(int a, int b) 
{ 
	return (a > b)? a: b; 
} 

int EDP( int n, int k)
{
	int table[n+1][k+1];
	
	int i,j,x,res;
	
	for(i=1; i<=n; ++i)
	{
		table[i][0] = 0;
		
		table[i][1] = 1;
	}
	
	for(j=1; j<=k; ++j)
		table[1][j] = j;
		
	for(i=2; i<=n; ++i)
	{
		for(j=2; j<=k; ++j)
		{
			table[i][j] = INT_MAX;
			
			for(x=1; x<=j; ++x)
			{
				res = 1 + max(table[i-1][x-1], table[i][j-x]);
				
				if(res < table[i][j])
					table[i][j] = res;
			}
		}
	}
	
	return table[n][k];
}

void main()
{
	int n = 2; // eggs
	
	int k = 36; // floors
	
	printf(" No. of trials with %d Eggs and %d Floors is = %d ", n, k, EDP(n,k));
}



