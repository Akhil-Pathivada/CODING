class TestJoinMethod1 extends Thread
{
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e){System.out.println(e);}
			System.out.println("Thread "+Thread.currentThread().getName()+ "is Running...." );
		}	
	}
	public static void main(String args[])
	{
		TestJoinMethod1 t1=new TestJoinMethod1();
		TestJoinMethod1 t2=new TestJoinMethod1();
		TestJoinMethod1 t3=new TestJoinMethod1();
		t1.start();
		try
		{
			t1.join();
		}
		catch(Exception e){System.out.println(e);}
		t2.start();
		t3.start();
		System.out.println("Thread 1 is alive : "+t1.isAlive());
		System.out.println("Thread 2 is alive : "+t2.isAlive());
		System.out.println("Thread 3 is alive : "+t3.isAlive());
		
		
	}
}