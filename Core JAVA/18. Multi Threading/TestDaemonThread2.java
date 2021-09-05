//If you want to make a user thread as Daemon, it must not be started otherwise it will throw IllegalThreadStateException.
class TestDaemonThread2 extends Thread
{
	public void run()
	{
		if(Thread.currentThread().isDaemon())
			System.out.println("Daemon Thread");
		else
			System.out.println("User Thread");
	}
	public static void main(String args[])
	{
		TestDaemonThread2 t1=new TestDaemonThread2();
		TestDaemonThread2 t2=new TestDaemonThread2();
		TestDaemonThread2 t3=new TestDaemonThread2();
		t1.start();
		t1.setDaemon(true);
		t2.start();
		t3.start();
	}
}