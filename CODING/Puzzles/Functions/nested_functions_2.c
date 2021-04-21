// Concept of Nested function.....

#include<stdio.h>

int func3(int);

void main()
{
	int func0();
	
	int func1()
	{
		printf(" Inside func1.");
	}
	
	int func2(int n)
	{
		func1();
		printf(" Inside func2.");
	}
	
	func3(2);
}

int func3(int n)
{
	// func2(3); Compile Error
	
	printf(" Inside func3.");
}

// Inside func3.
