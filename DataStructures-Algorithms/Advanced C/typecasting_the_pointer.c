// TypeCasting the pointers

#include<stdio.h>

void main()
{
	char ch='A';
	char *cp=&ch;
	printf(" *cp :%c \n",*cp);
	
	int num=12;
	int *ip=&num;
	printf(" *ip :%d \n",*ip);
	
	ip=(int*)cp;
	printf(" *ip: %c \n",*ip);
	
	void *gp;
	gp=cp;
	printf(" *gp: %c \n",*(char*)gp);
	
	gp=&num;
	printf(" *gp: %d \n",*(int*)gp);
	
	/*
	COMPILE ERROR
	
	gp=(int*)cp;
	printf(" *gp: %c \n",*gp); --------> dereferencing ‘void *’ pointer
	*/
}

/*

 *cp :A 
 *ip :12 
 *ip: A 
 *gp: A 
 *gp: 12 

*/
