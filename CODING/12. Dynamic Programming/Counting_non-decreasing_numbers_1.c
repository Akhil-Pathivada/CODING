/*
A number is non-decreasing if every digit (except the first one) is greater than or equal to previous digit.
For example, 223, 4455567, 899, are non-decreasing numbers.
So, given the number of digits n, you are required to find the count of total non-decreasing numbers with n digits.

(Dynamic Programming)

Time Complexity : O(10*n)
Space Complexity : O(10*n)
*/

#include<stdio.h>
#include<string.h>

int countNonDecreasing(int n)
{
	int table[10][n+1];
	
	memset(table,0,sizeof table);
	
	int digit, len, x;
	
	// Base Cases
	for(x=0; x<=10; ++x)
		table[x][1] = 1;
	
	for(digit=0; digit<=9; ++digit)
	{
		for(len=2; len<=n; ++len)
		{
			for(x=0; x<=digit; ++x)
				
				table[digit][len] += table[x][len-1];
		}
	}
	
	int count = 0;
	
	// Computing the total sum for length 'n'
	for(x=0; x<=9; ++x)
		count += table[x][n];
	
	return count;
}

void main()
{
	int n = 3;
	
	printf("Total no. of Non-decreasing numbers = %d ", countNonDecreasing(n));
}
