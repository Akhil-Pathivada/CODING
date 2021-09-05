//You caught the exception i.e. handle the exception using try/catch.
import java.io.*;  
class M
{  
     void method()throws IOException
	 {  
      throw new IOException("device error");  
     }  
}  
public class ThrowsDemo4
{  
       public static void main(String args[])
	   {  
			try
			{  
				M m=new M();  
				m.method();  
			}
			catch(Exception e){System.out.println("exception handled"+e);}     
      
        System.out.println("normal flow...");  
      }  
}  
/*
exception handledjava.io.IOException: device error
normal flow...

*/