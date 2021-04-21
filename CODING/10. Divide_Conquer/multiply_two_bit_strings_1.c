/*
Given two binary strings that represent value of two integers, find the product of two strings. 
For example, if the first bit string is “1100” and second bit string is “1010”, output should be 120.

For simplicity, let the length of two strings be same and be n.

Time Complexity : O(n^2)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<math.h>

int powFunc(int base,int n) // treat as....O(1)
{
	int res=1;
	
	for( ;n>0; --n)
		res*=base;
	
	return res;
}

int getProduct(char *str1,char *str2,int len)
{
	int product=0;
	
	for(int j=len; j>=0; --j) 
	{
		int n=0;
		int a=str2[j]-'0';
		
		for(int i=len; i>=0 ; --i)
		{
			int b=str1[i]-'0';

			n +=  (a*b)*powFunc(2,len-i); 
		}
		
		product = product + (n<<(len-j));
	}	
	return product;	
}

void main()
{
	char str1[]="1011";
	char str2[]="1101";
	
	int n=sizeof(str1)/sizeof(*str1);
	
	printf(" Product : %d ",getProduct(str1,str2,n-2));
}
