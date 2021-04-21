// Operations can't be applied on Arrays......

#include<stdio.h>
#include<stdlib.h>
int main()
{
	int b[]={11,12};
	printf(" ++*b=%d \n",++*b); 
	/*printf(" *b++ =%d \n",*b++);
	++b;
	b++;		 ----->COMPILE ERRORS */
	int *a=(int *)malloc(sizeof(int)*2);
	a[0]=11;
	a[1]=12;
	printf(" *a++ =%d \n",*a++);
	printf(" *a=%d \n",*a);
}
