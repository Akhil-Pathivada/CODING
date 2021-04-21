//This is a constant pointer to constant character. You can neither change the value pointed by ptr nor the pointer ptr. 

#include<stdio.h>
void main()
{
	char a='A',b='B';
	const char *const ptr=&a;
	printf(" value pointed by PTR : %c \n",*ptr);
	//*ptr=&b; (COMPILE ERROR)
	//*ptr=b; (COMPILE ERROR)
	printf(" value pointed by PTR : %c \n",*ptr);
}
