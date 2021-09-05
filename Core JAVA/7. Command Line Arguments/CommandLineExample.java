// program to check for command line arguments
class CommandLineExample
{
	public static void main(String args[])
	{
		if(args.length > 0)
		{
			for(String val:args)
				System.out.println(val);
		}
		else
			System.out.println("no command line arguments are found....");
	}
}
/*
input: 100 200 300
ouput:
100 
200
300
*/