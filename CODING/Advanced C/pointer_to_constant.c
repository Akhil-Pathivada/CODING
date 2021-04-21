//This is a pointer to a constant character. You cannot change the value pointed by ptr, but you can change the pointer itself.

#include<stdio.h>
void main()
{
	char a='A',b='B';
	const char *ptr=&a;
	printf(" value pointed by PTR : %c \n",*ptr);
	//*ptr=b; (COMPILE ERROR)
	ptr=&b;
	printf(" value pointed by PTR : %c \n",*ptr);
}
