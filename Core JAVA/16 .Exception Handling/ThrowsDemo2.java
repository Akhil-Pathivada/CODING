// with 'throws' declaration
import java.util.*;
class ThrowsDemo2
{
	static void throwOne() throws IllegalAccessException
	{
		System.out.println("Inside throw One");
		throw new IllegalAccessException("demo");
	}
	public static void main(String args[]) 
	{
		try
		{
			throwOne();
		}
		catch(IllegalAccessException e){System.out.println("Caught : "+e);}
	}
}
/*
Inside throw One
Caught : java.lang.IllegalAccessException: demo
*/