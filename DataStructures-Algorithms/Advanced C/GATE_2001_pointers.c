[PI] int * g (void) 
{ 
  int x= 10; 
  return (&x); 
}  
   
[P2] int * g (void) 
{ 
  int * px; 
  *px= 10; 
  return px; 
} 
   
[P3] int *g (void) 
{ 
  int *px; 
  px = (int *) malloc (sizeof(int)); 
  *px= 10; 
  return px; 
}

Which of the above three functions are likely to cause problems with pointers?

/*
 In P1, pointer variable x is a local variable to g(), and g() returns pointer to this variable.
 x may vanish after g() has returned as x exists on stack. So, &x may become invalid. 
In P2, pointer variable px is being assigned a value without allocating memory to it. P3 works perfectly fine. 
Memory is allocated to pointer variable px using malloc(). So, px exists on heap, it’s existence will remain in memory even after return of g() as it is on heap. 
*/
