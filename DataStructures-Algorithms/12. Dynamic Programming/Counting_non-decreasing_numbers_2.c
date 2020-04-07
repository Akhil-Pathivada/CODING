/*
A number is non-decreasing if every digit (except the first one) is greater than or equal to previous digit.
For example, 223, 4455567, 899, are non-decreasing numbers.
So, given the number of digits n, you are required to find the count of total non-decreasing numbers with n digits.

(Direct Formula)

Count of non-decreasing numbers with n digits = 
                                N*(N+1)/2*(N+2)/3* ....*(N+n-1)/n
Where N = 10

Time Complexity : O(10*n)
Space Complexity : O(10*n)
*/

#include<stdio.h>
#include<string.h>

int countNonDecreasing(int n)
{
	int N = 10;
	
	long int count = 1;
	
	for(int i=1; i<=n; ++i)
	{
		count *= N+i-1;
		
		count /= i;
	}
	
	return count;
}

void main()
{
	int n = 3;
	
	printf("Total no. of Non-decreasing numbers = %d ", countNonDecreasing(n));
}
