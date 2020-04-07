/*
 Example on understanding of Dangling pointer....
 Dangling Pointer is a pointer that doesn’t point to a valid memory location. 
 
 Deallocating a memory pointed by 'ptr' causes dangling pointer 
*/

#include<stdio.h>
#include<stdlib.h>

void main()
{
	int *ptr = (int*)malloc(sizeof(int));
	
	// After below free call, ptr becomes a dangling pointer 
	free(ptr);
	
	// No more a Dangling Pointer
	ptr = NULL;
}
