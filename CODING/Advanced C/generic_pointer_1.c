// Understanding the behaviour of 'Generic Pointer'

#include<stdio.h>

void main()
{
	void *gp;
	
	int num = 10;
	
	int *ip = &num;
	
	printf(" gp : %p \n\n",gp);
	
	gp = &num;
	
	printf(" &num : %p \n",&num);
	printf(" gp : %p \n",gp);
	printf(" *(int*)gp: %d \n\n",*(int*)gp);
	
	gp = ip;
	
	printf(" ip : %p \n",ip);
	printf(" gp : %p \n",gp);
	printf(" *(int*)gp: %d \n\n",*(int*)gp);
	
	gp = (void*)ip;
	
	printf(" gp : %p \n",gp);
	printf(" *(int*)gp: %d \n",*(int*)gp);
}

/*

 gp : 0x7ffcad3edd40 

 &num : 0x7ffcad3edc44 
 gp : 0x7ffcad3edc44 
 *(int*)gp: 10 

 ip : 0x7ffcad3edc44 
 gp : 0x7ffcad3edc44 
 *(int*)gp: 10 

 gp : 0x7ffcad3edc44 
 *(int*)gp: 10 

  
*/
