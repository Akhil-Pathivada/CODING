class ThreadGroupDemo implements Runnable
{
	public void run()
	{
		System.out.println(Thread.currentThread().getName());
	}
	public static void main(String args[])
	{
		ThreadGroupDemo obj=new ThreadGroupDemo();
		ThreadGroup tg=new ThreadGroup("Parent Group Thread");
		Thread t1=new Thread(tg,obj,"one");
		Thread t2=new Thread(tg,obj,"two");
		Thread t3=new Thread(tg,obj,"three");
		t1.start();
		t2.start();
		t3.start();
		 System.out.println("Thread Group Name: "+tg.getName());  
         tg.list();  
	}
}