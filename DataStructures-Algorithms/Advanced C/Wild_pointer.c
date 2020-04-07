/*
A pointer which has not been initialized to anything (not even NULL) is known as wild pointer. 
The pointer may be initialized to a non-NULL garbage value that may not be a valid address.

*/

void main()
{
	int *ptr; /* Wild Pointer */
	
	int x = 5;
	
	ptr = &x; /* ptr is not a Wild Pointer now */
}
