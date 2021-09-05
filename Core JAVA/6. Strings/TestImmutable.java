// Immutable simply means unmodifiable or unchangeable.
class TestImmutable
{
	public static void main(String args[])
	{
		String s1="Sachin";
		s1.concat("Tendulkar"); // creates a new 'string object' called 'Sachin Tendulkar'
		System.out.println("s1 : "+s1);
	}
}
/*
s1 : Sachin
*/