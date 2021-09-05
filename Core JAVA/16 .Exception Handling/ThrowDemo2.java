// Java program that demonstrates the use of throw 
class ThrowDemo2
{ 
    static void fun() 
    { 
        try
        { 
            throw new NullPointerException("demo"); 
        } 
        catch(NullPointerException e) 
        { 
            System.out.println("Caught inside fun()."); 
			throw e; // rethrowing the exception 
        } 
    } 
  
    public static void main(String args[]) 
    { 
        try
        { 
            fun(); //reCaughts here
        } 
        catch(NullPointerException e) 
        { 
            System.out.println("Caught in main."+e); 
        } 
    } 
} 
/*
Caught inside fun().
Caught in main.java.lang.NullPointerException: demo

*/