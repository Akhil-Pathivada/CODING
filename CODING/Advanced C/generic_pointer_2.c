// Understanding the behaviour of 'Generic Pointer'

#include<stdio.h>

void main()
{
	void *gp;
	int arr[]={4,5,6};
	
	printf(" gp : %p \n\n",gp);

	gp=arr;

	printf(" arr : %p \n",arr);
	printf(" gp : %p \n\n",gp);
	
	
    /*  printf(" *gp: %d \n",*gp);	---->COMPILE ERROR */
    	printf(" *arr : %d \n",*arr);
    	printf(" *(int*)gp : %d \n",*(int*)gp);
	printf(" *(int*)(gp+1) : %d \n\n",*(int*)(gp+1));
	
	gp=arr+1;
	
	printf(" *(int*)gp : %d \n",*(int*)gp);
}

/*

 gp : 0x55e6c52587b0 

 arr : 0x7ffcf2cff20c 
 gp : 0x7ffcf2cff20c 

 *arr : 4 
 *(int*)gp : 4 
 *(int*)(gp+1) : 83886080 

 *(int*)gp : 5 
 
*/
