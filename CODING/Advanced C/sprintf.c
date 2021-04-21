// 'sprintf' stands for “String print”. Instead of printing on console, it store output on char buffer which are specified in sprintf
// Example program to demonstrate sprintf() 

#include<stdio.h> 
int main() 
{ 
    char buffer[50]; 
    int a = 10, b = 20, c; 
    c = a + b; 
    sprintf(buffer, "Sum of %d and %d is %d", a, b, c); 

    // The string "sum of 10 and 20 is 30" is stored  
    // into buffer instead of printing on stdout 
    printf("%s", buffer); 
} 

