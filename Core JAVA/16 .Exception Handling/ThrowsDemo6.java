//You declare the exception i.e. specifying throws with the method.
// program for 'exception occurs'
import java.io.*;  
class M
{  
	void method()throws IOException
	{  
		throw new IOException("error");
	}  
}  
class ThrowsDemo6
{  
   public static void main(String args[])throws IOException
   {
	 //declare exception  
     M m=new M();  
     m.method();  
    System.out.println("normal flow...");  
  }  
} 
/* Run Time Error
Exception in thread "main" java.io.IOException: error
        at M.method(ThrowsDemo6.java:8)
        at ThrowsDemo6.main(ThrowsDemo6.java:17)
*/