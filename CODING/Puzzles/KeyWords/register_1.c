// Understanding behaviour of 'register' variable

#include<stdio.h> 
 
int main() 
{ 
	register int i = 10; 
	
	int* a = &i; 
	
	printf("%d", *a); 
} 

/*
register.c:8:5: error: address of register variable ‘i’ requested
     int* a = &i;

Reason :
If you use & operator with a register variable then compiler may give an error, because when we say a variable is a register,
it may be stored in a register instead of memory and accessing address of a register is invalid. 

*/
