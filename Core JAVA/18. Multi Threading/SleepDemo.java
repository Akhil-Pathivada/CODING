//Example of sleep method in java
class SleepDemo extends Thread
{  
    public void run()
	{  
      for(int i=1;i<5;i++)
	  {  
        try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e){System.out.println(e);}  
        System.out.println(i);  
      }  
    }  
    public static void main(String args[])
	{  
      SleepDemo t1=new SleepDemo();  
      SleepDemo t2=new SleepDemo();  
       
      t1.start();  
      t2.start();  
    }  
} 
/*
Reason : 

As you know well that at a time only one thread is executed. If you sleep a thread for the specified time,the thread shedular picks up another thread and so on. 


output : 

1
1
2
2
3
3
4
4

*/

 
