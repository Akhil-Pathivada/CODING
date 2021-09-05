class MultiThreadingDemo2 implements Runnable
{
    public void run()
    {
        try
        {
            System.out.println ("Thread " +
                                Thread.currentThread().getId() +
                                " is running");
        }
        catch (Exception e)
        {
            System.out.println ("Exception is caught");
        }
    }
	public static void main(String[] args)
    {
        int n = 8; // Number of threads
        for (int i=0; i<8; i++)
        {
            Thread object = new Thread(new MultiThreadingDemo2());
           object.start();
        }
    }
}