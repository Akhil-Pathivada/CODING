// Creating a Thread
// Java Thread Example by extending Thread class
class ThreadDemo extends Thread
{
	public void run()
	{
		System.out.println("Thread : "+Thread.currentThread().getName()+ " is Running....");
	}
	public static void main(String args[])
	{
		ThreadDemo t1=new ThreadDemo();
		t1.setName("ravindra"); // naming the thread....
		t1.start();
		
		
	}
}
/*
Output:thread : Ravindra is running...
*/