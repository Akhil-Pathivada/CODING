
// Importance of the 'static' keyword

#include<stdio.h>
int func()
{
	static int count; // problem occurs without 'static'
	
	return ++count;
}

int main()
{
	func();
	func();
	func();
	printf(" %d times func() called \n",func());
}

// 4 times func() called 
