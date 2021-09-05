//JVM calls main() method which receives string array as arguments only.
class Main_overload
{  
    public static void main(String args[])
	{
		System.out.println("\n main with String[]");
	}  
    public static void main(String args)
	{
		System.out.println("main with String");
	}  
    public static void main()
	{
		System.out.println("main without args");
	}  
 }  
 /*
 output : 
 
		 main with String[]
		 */