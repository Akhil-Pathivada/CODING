// Array of Pointers

#include<stdio.h>

int main()
{
	char *name[]={"RAVI","RAVINDRA","RAVINDRABABU"};
	printf("\nname :: %p",name);
	printf("\n*name :: %s",*name);
	printf("\n*(name+1) :: %s",*(name+1));
	printf("\n*name+1 :: %s",*name+1);
	printf("\n*(name+2)+7 :: %s",*(name+2)+7);
	printf("\n*(*(name+2)+7) :: %c",*(*(name+2)+7));
	printf("\nname[2][7] :: %c \n",name[2][7]);
	
}

/*
name :: 0x7ffefd9b8b80
*name :: RAVI
*(name+1) :: RAVINDRA
*name+1 :: AVI
*(name+2)+7 :: ABABU
*(*(name+2)+7) :: A
name[2][7] :: A 
*/
