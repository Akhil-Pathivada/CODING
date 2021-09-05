// Creating a Thread
//Java Thread Example by implementing Runnable interface
class ThreadDemo2 implements Runnable
{
	public void run()
	{
		System.out.println("Thread "+Thread.currentThread().getId()+ " is Running....");
	}
	public static void main(String args[])
	{
		ThreadDemo2 m1=new ThreadDemo2();
		Thread t1=new Thread(m1);
		System.out.println(Thread.currentThread().getName()+" is ....running....");
		t1.start();
	}
}
/*
1 is ....running....
Thread 13is Running....
*/