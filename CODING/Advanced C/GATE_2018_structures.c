#include <stdio.h>
struct Outnode 
{ 
    char x, y, z ; 
};

int main ()
{ 
    struct Outnode p = {'1', '0', 'a'+2} ; 
    struct Outnode *q = &p ; 
    printf ("%c, %c  \n", *((char*)q+1), *((char*)q+2)) ; 
    return 0 ; 
} 
// 0,c
