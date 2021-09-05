// Java program to explain the 
// concept of joining a thread. 
import java.io.*; 
  
// Creating thread by creating the 
// objects of that class 
class ThreadJoining extends Thread 
{ 
    @Override
    public void run() 
    { 
        for (int i = 0; i < 2; i++) 
        { 
            try
            { 
                Thread.sleep(500); 
                System.out.println("Current Thread: " + Thread.currentThread().getName()); 
            } 
  
            catch(Exception ex) 
            { 
                System.out.println("Exception has" +  " been caught" + ex); 
            } 
            System.out.println(i); 
        } 
    } 
} 
  
class DemoJoin2
{ 
    public static void main (String[] args) 
    { 
  
        // creating two threads 
        ThreadJoining t1 = new ThreadJoining(); 
        ThreadJoining t2 = new ThreadJoining(); 
        ThreadJoining t3 = new ThreadJoining(); 
  
        // thread t1 starts 
        t1.start(); 
  
        // starts second thread after when 
        // first thread t1 is died. 
		System.out.println("\n main thread : "+ Thread.currentThread().isAlive());
        try
        { 
            System.out.println("Current Thread: "+ Thread.currentThread().getName()); 
            t1.join(); 
        } 
  
        catch(Exception ex) 
        { 
            System.out.println("Exception has " + "been caught" + ex);                     
        } 
  
        // t2 starts 
        t2.start(); 
  
        // starts t3 after when thread t2 is died. 
        try
        { 
            System.out.println("Current Thread: "+ Thread.currentThread().getName()); 
            t2.join(); 
        } 
  
        catch(Exception ex) 
        { 
            System.out.println("Exception has been" + " caught" + ex); 
        } 
        System.out.println("\n main thread : "+ Thread.currentThread().isAlive());
		t3.start(); 
		 try
        { 
            System.out.println("Current Thread: "+ Thread.currentThread().getName()); 
            t3.join(); 
        }
		catch(Exception ex) 
        { 
            System.out.println("Exception has been" + " caught" + ex); 
        } 
		 System.out.println("\n main thread : "+ Thread.currentThread().isAlive());
    } 
}