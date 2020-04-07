// Understanding behaviour of 'register' variable

#include<stdio.h> 
 
int main() 
{ 
	int a = 10;
	
	register int *i = &a; 
	
	printf("%d", *i); 
} 

/*
Output : 10 

Reason : 
	'register' keyword can be used with pointer variables. Obviously, a register can have address of a memory location. 
	There would not be any problem with the above program.
*/	
