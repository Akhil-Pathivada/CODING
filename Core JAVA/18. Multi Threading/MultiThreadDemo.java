// Create multiple threads.
class NewThread implements Runnable
{
	String name; // name of thread
	Thread t;
	NewThread(String threadname)
	{
		name = threadname;
		t = new Thread(this, name);
		System.out.println("New thread: " + t);
		t.start(); // Start the thread
	}
	// This is the entry point for thread.
	public void run() 
	{
		try 
		{
			for(int i = 5; i > 0; i--) 
			{
				System.out.println(name + ": " + i);
				Thread.sleep(1000);
			}
		}
		catch (InterruptedException e) {System.out.println(name + "Interrupted");}
	System.out.println(name + " exiting.");
	}
}
class MultiThreadDemo 
{
	public static void main(String args[])
	{
		new NewThread("One"); // start threads concurrently....
		new NewThread("Two");
		new NewThread("Three");
		try 
		{
			//System.out.println("Calling.....");
			// wait for other threads to end
			Thread.sleep(1);
		}
		catch (InterruptedException e) {System.out.println("Main thread Interrupted");}
		System.out.println("Main thread exiting.");
	}
}
/*
New thread: Thread[One,5,main]
New thread: Thread[Two,5,main]
New thread: Thread[Three,5,main]
Two: 5
One: 5
Three: 5
Three: 4
One: 4
Two: 4
One: 3
Three: 3
Two: 3
One: 2
Three: 2
Two: 2
Two: 1
Three: 1
One: 1
One exiting.
Three exiting.
Two exiting.
Main thread exiting.
*/