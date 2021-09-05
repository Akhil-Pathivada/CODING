//In java, string objects are immutable. Immutable simply means unmodifiable or unchangeable
class Concat
{
	public static void main(String args[])
	{
		String s="Sachin";
		System.out.println("\n "+s);
		s=s.concat("Tendulkar");
		System.out.println("\n "+s);
	}
}