//But if we explicitely assign it to the reference variable, it will refer to "Sachin Tendulkar" object.
class TestImmutable2
{
	public static void main(String args[])
	{
		String s1="Sachin";
		s1=s1.concat("Tendulkar"); // creates a new 'string object' called 'Sachin Tendulkar'
		System.out.println("s1 : "+s1);
	}
}
/*
s1 : Sachin Tendulkar
*/

/*
In such case, s points to the "Sachin Tendulkar". Please notice that still sachin object is not modified.

*/