//Can we start a thread twice
/*
No. After starting a thread, it can never be started again. 
If you does so, an IllegalThreadStateException is thrown. In such case, thread will run once but for second time, it will throw exception.
*/
public class ThreadTwice extends Thread
{
	public void run()
	{
		System.out.println("Thread is Running....");
	}
	public static void main(String args[])
	{
		ThreadTwice t1=new ThreadTwice();
		t1.start();
		t1.start();
	}
}
/*
Thread is Running....
Exception in thread "main" java.lang.IllegalThreadStateException
        at java.base/java.lang.Thread.start(Unknown Source)
        at ThreadTwice.main(ThreadTwice.java:16)
*/