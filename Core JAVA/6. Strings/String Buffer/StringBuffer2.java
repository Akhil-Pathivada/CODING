//The insert() method inserts the given string with this string at the given position.
class StringBuffer2
{
	public static void main(String args[])
	{
		StringBuffer s=new StringBuffer("Hello ");
		s.insert(1,"JAVA");
		System.out.println(s);
		s.insert(8,"123");
		System.out.println(s);
	}
}
/*
HJAVAello
HJAVAell123o
*/