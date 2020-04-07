// A Simple example on Structures....
#include<stdio.h>

struct node
{
	int i;
	int *c;	
};

int main()
{
	struct node a[2],*p;
	int b[2]={30,40};
	p=&a[0];
	a[0].i=10;
	a[1].i=20;
	a[0].c=b;
	int x;
	printf("\n ++p->i :: %d",++p->i);// 11
	printf("\n (++p)->i :: %d",(++p)->i);// 20
	(--p)->i;
	x=(p++)->i;
	printf("\n (p++)->i :: %d",x); // 11
	(p--)->i;
	x=*p->c;
	printf("\n *p->c :: %d ",x);// 30
	x=*p->c++;
	printf("\n *p->c++ :: %d",x); // 30
	*p->c--;
	x=(*p->c)++;
	printf("\n (*p->c)++ :: %d",x); // 30
	x=*p++->c;
	printf("\n *p++->c :: %d\n",x);//31 
	

}
