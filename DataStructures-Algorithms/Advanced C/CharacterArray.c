#include<stdio.h>
int main()
{
	char s[]="RAVINDRA";
	char *ptr="MAHESH";
	printf("\n s :: %s",s);
	printf("\n s+2 :: %s",s+2);
	//printf("\n s[2] :: %s",s[2]);// COMPILE ERROR
	printf("\n s[2] :: %c",s[2]);
	printf("\n------------------");
	printf("\n ptr :: %s",ptr);
	printf("\n ptr+2 :: %s",ptr+2);
	//printf("\n *(ptr+2) :: %s",*(ptr+2));// COMPILE ERROR
	printf("\n *(ptr+2) :: %c  \n",*(ptr+2));
}
