// Understanding the far && huge pointers....

#include<stdio.h>
int main()
{
    char *s1;
    
    char far *s2;
    
    char huge *s3;
    
    printf("%d, %d, %d\n", sizeof(s1), sizeof(s2), sizeof(s3));
}

// 2, 4, 4
