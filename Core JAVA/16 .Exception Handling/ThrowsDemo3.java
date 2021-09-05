//another example for 'throws' 
import java.util.*;
import java.io.IOException;
class ThrowsDemo3
{
	void M() throws IOException
	{
		throw new IOException("error"); // throws the error
	}
	void N() throws IOException
	{
		M();
	}
	void P() 
	{
		try
		{
			N();
		}
		catch(Exception e){System.out.println("Exception Handled.....");}
	}
	public static void main(String args[])
	{
		ThrowsDemo3 ob=new ThrowsDemo3();
		ob.P();
		System.out.println("Normally executed.....");
	}
}
/*
Exception Handled.....
Normally executed.....
*/