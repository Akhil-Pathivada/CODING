
// We can declare functions, call functions, execute(define) functions within other functions..... 

#include<stdio.h>

void main()
{
	int func0();
	
	int func1()
	{
		printf(" Inside func1.");
		
		//func3(51); Compile Error
 	}
	
	int func2(int n)
	{
		printf(" Inside func2.");
		
	}
	
	int func3(int n)
	{
		printf(" Inside func3.");
		func2(2);
	}
	
	
	func1();
	
	func3(23);
}

/*
 Inside func1.
 Inside func3. 
 Inside func2.
 
*/
