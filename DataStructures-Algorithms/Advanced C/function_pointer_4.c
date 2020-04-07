// Program for 'pointer to functions'

#include<stdio.h>

int Add(int a,int b)
{
	return a+b;
}

int Subtract(int a,int b)
{
	return a-b;
}

int main()
{
	void (*gp)(void,void);
	
	int (*fp)(int,int);	

	gp = (void (void,void))fp;
	//printf("sum = %d \n",gp(5,6));
	//fp = Subtract;
	//printf("diffrence = %d \n",fp(5,6));
}
