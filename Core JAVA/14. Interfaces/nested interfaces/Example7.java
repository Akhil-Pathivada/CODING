// Java program to demonstrate private  
// specifier for nested interface. 
class Test 
{ 
    private interface Yes // Compile Time Error
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
  
class Example7
{ 
    public static void main(String[] args) 
    { 
        Testing t = new Testing(); 
		t.show(); 
    } 
} 
/*
Example7.java:11: error: Yes has private access in Test
class Testing implements Test.Yes

*/