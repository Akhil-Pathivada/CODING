// without 'throws' and 'try/catch' declaration
import java.util.*;
class ThrowsDemo
{
	static void throwOne() //throws IllegalAccessException  // compile error
	{
		System.out.println("Inside throw One");
		throw new IllegalAccessException("demo");
	}
	public static void main(String args[]) throws IllegalAccessException
	{
		throwOne();
	}
}
/*
ThrowsDemo.java:7: error: unreported exception IllegalAccessException; must be caught or declared to be thrown
                throw new IllegalAccessException("demo");
                ^
1 error
*/