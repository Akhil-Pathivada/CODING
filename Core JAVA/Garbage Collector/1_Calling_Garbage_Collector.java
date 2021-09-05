
// Different ways to call Garbage Collector....

class GarbageCollector
{
	public static void main(String args[])
	{
		GarbageCollector ob1 = new GarbageCollector();

		GarbageCollector ob2 = new GarbageCollector();

		ob1 = null;

		// Requesting JVM to run Garbage Collector
		System.gc();

		ob2 = null;

		Runtime.getRuntime().gc();
	}

	@Override
	protected void finalize() throws Throwable
	{
		System.out.println("Garbage Collector called");

		System.out.println("Object Garbage collected : " + this);
	}
} 