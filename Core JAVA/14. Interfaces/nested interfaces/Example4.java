// Java program to demonstrate an interface cannot 
// have non-public member interface. 
interface Test 
{ 
    protected interface Yes // Compile Time Error
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
  
class Example4
{ 
    public static void main(String[] args) 
    { 
        Testing ob = new Testing(); 
        ob.show(); 
    } 
} 
/*

Example4.java:5: error: illegal combination of modifiers: public and protected
    protected interface Yes
              
*/