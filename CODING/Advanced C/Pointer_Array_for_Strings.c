// Difference between the Pointer declaration and Array declarations of a STRING

#include<stdio.h>

int main()
{
	char str1[]="RAVINDRA";	
	char *str2="MAHESH";

	printf("\nstr1 :: %s",str1);	
	printf("\nstr2 :: %s",str2);
	printf("\nstr1[2] :: %c",str1[2]);
	printf("\nstr2[2] :: %c",str2[2]);
	printf("\n*(str2+2) :: %c",*(str2+2));
	str1[2]='K';
	//*(str2+2)='K'; // COMPILE ERROR
	printf("\nstr1[2] :: %c",str1[2]);
	printf("\nstr2[2] :: %c \n",str2[2]);
}

/*
 This is because we were not able to modify the Pointer declared Strings, because they acts as STRING CONSTANTS.
 We just allowed to access them....

*/
