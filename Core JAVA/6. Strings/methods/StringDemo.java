// Why string is immutable
class StringDemo
{
	public static void main(String args[])
	{
		String s1="akhil";
		String s2="akhil";
		System.out.println("String 1 : "+s1+" String 2 : "+s2);
		s2+=" pathivada";
		System.out.println("String 1 : "+s1+" String 2 : "+s2);
	}
}