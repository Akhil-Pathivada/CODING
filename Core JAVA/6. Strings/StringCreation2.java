// using 'new' keyword
class StringCreation2
{
	public static void main(String args[])
	{
		String s1=new String("Welcome");
		char ch[]={'W','e','l','c','o','m','e'};
		String s2=new String(ch);
		System.out.println("s1: "+s1+" s2: "+s2);
	}
}
/*
s1: Welcome s2: Welcome
*/