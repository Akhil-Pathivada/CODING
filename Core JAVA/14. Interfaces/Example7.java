// An example to show that interfaces can 
// have 'default methods' from JDK 1.8 onwards 
interface in1 
{ 
    final int a = 10; 
    default void display() 
    { 
        System.out.println("hello"); 
    } 
}  
// A class that implements interface. 
class testClass implements in1 
{ 
	
} 
class Example7
{
	public static void main (String[] args) 
    { 
        testClass t = new testClass(); 
        t.display(); 
		System.out.println(" a : "+ t.a);
    }
}
/*

hello
 a : 10

*/