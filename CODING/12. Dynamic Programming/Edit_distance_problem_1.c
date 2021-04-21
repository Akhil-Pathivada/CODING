/*
Given two strings str1 and str2 and below operations that can performed on str1.
Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
	1.Insert
	2.Remove
	3.Replace

(Brute-Force method)

Time Complexity : O(3^ min(m,n))
Space Complexity : O(m+n)
*/

#include<stdio.h> 
#include<string.h> 

int min( int a, int b, int c)
{
	return (a < b) ? (a<c ? a :c) : (b<c ? b : c);
}

int editDistance( char *str1, char *str2, int m, int n)
{
	if(!m)
		return n;
		
	if(!n)
		return m;
		
	if(str1[m-1] == str2[n-1])
		return editDistance(str1, str2, m-1, n-1);
		
		
	return 1 + min( editDistance(str1, str2, m, n-1), // Insert
			
			editDistance(str1, str2, m-1, n), // Remove
			
			editDistance(str1, str2, m-1, n-1) // Replace

		      );
}

int main() 
{ 
  
    char str1[] = "sunday"; 
    
    char str2[] = "saturday"; 
  
    printf(" Min. Operations required = %d ",editDistance( str1 , str2 , strlen(str1), strlen(str2))); 
  
} 

