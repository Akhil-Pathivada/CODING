//You declare the exception i.e. specifying throws with the method.
// program for 'exception will not occurs'
import java.io.*;  
class M
{  
	void method()throws IOException
	{  
		System.out.println("device operation performed");  
	}  
}  
class ThrowsDemo5
{  
   public static void main(String args[]) throws Exception
   {
	 //declare exception  
     M m=new M();  
     m.method();  
    System.out.println("normal flow...");  
  }  
} 
/*
device operation performed
normal flow...
*/