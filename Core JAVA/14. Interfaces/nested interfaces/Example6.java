// Java program to demonstrate protected  
// specifier for nested interface. 
class Test 
{ 
    protected interface Yes 
    { 
        void show(); 
    } 
} 
  
class Testing implements Test.Yes 
{ 
    public void show() 
    { 
        System.out.println("show method of interface"); 
    } 
} 
  
class Example6
{ 
    public static void main(String[] args) 
    { 
        Testing t = new Testing();
        t.show(); 
    } 
} 
/*
show method of interface

*/