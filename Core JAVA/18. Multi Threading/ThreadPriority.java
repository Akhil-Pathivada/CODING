//giving priorities to the Threads
class ThreadPriority extends Thread
{
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + "is running");
		System.out.println("priority : "+Thread.currentThread().getPriority() + " is running");
	}
	public static void main(String args[])
	{
		ThreadPriority t1=new ThreadPriority();
		ThreadPriority t2=new ThreadPriority();
		ThreadPriority t3=new ThreadPriority();
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}
}

// min-1, max-10 ,normal-5