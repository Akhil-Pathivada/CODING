
// Difference between Array and Pointers

#include<stdio.h>
int main()
{
	int a[10] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };	
	int *b = a;
	printf(" %ld\n %ld \n", sizeof(a), sizeof(b));
}

/*
And the output is (assuming size of int is 4 bytes and address size is 8 bytes) –

 40
 8 

*/
