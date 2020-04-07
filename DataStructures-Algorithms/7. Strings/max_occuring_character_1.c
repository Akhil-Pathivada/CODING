/*
Program to get the Maximum occuring character in the String....(Naive Approach)
Time Complexity : O(n^2)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

char getMaxChar(char *str)
{
	int curr_count,max_count=-9999;
	char curr_char,max_char,*s1=str,*s2=str;

	for(char *s1=str ;*s1; s1++)
	{
		curr_count=1;
		curr_char=*s1;

		for(char *s2=str+1 ;*s2; s2++)
		{
			if(*s1==*s2)  
				++curr_count;
		}	

		if(curr_count>max_count)
		{
			max_count=curr_count;
			max_char=curr_char;
		}
	}

	return max_char;
}
void main()
{
	char *str="RAVINDRAAA";
	printf("**Maximum Occuring character : %c **\n",getMaxChar(str));
}
