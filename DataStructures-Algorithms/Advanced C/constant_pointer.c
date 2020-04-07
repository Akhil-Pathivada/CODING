// This is a constant pointer to non-constant character. You cannot change the pointer p, but can change the value pointed by ptr.
#include<stdio.h>
void main()
{
	char a='A',b='B';
	char *const ptr=&a;
	printf(" value pointed by PTR : %c \n",*ptr);
	//*ptr=&b; (COMPILE ERROR)
	*ptr=b;
	printf(" value pointed by PTR : %c \n",*ptr);
}
