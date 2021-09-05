//Another feature that was added in JDK 8 is that 
//we can now define static methods in interfaces which can be called independently without an object. 
//Note: these methods are not inherited.
interface in1 
{ 
    final int a = 10; 
    static void display() 
    { 
        System.out.println("hello"); 
    } 
} 
// A class that implements interface. 
class testClass implements in1 
{  
	
} 
class Example8
{
	public static void main (String[] args) 
    { 
        in1.display(); 
		System.out.println(" a : " + in1.a);
    } 
}
/*

hello
 a : 10

*/