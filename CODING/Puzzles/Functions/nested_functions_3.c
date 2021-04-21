
/*
 C program to illustrate the 
 concept of Nested function.
*/ 

#include <stdio.h> 

int main(void) 
{ 
    printf("main() \n"); 
    
    int fun() 
    { 
        printf("fun() \n"); 
  
        // defining view() function inside fun() function. 
        int view() 
        { 
            printf("view() \n"); 
        } 
  	
  	view(); 
    } 
    
    fun();
    
    // view(); Compile Error 
} 

/*
main() 
fun() 
view() 
*/

