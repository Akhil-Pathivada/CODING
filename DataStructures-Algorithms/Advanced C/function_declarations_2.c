// Function declarations.....

#include<stdio.h>

void main()
{
	double Sum(int,int),dnum,*dp;

	int getMax(int[]),arr[5];
	
	dnum=31;
	dp=&dnum;
	
	printf("*dp : %f \n",*dp);

	Sum(2,3);
	getMax(arr);
}

double Sum(x,y)
int x,y;
{
	printf("Executed Sum Func. \n");
}

int getMax(arr)
int arr[];
{
	printf("Executed getMax Func. \n");
}

/*

*dp : 31.000000 
Executed Sum Func. 
Executed getMax Func. 

*/
