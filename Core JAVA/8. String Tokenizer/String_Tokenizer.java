import java.util.*; 
class String_Tokenizer
{
	public static void main(String args[])
	{
		StringTokenizer st1=new StringTokenizer("Hello Akhil Pathivada How are you?");
		System.out.println(st1.countTokens());
		while(st1.hasMoreTokens())
		{
			System.out.println(st1.nextToken());
		}
		
		System.out.println("------------");
		StringTokenizer st2=new StringTokenizer("Hello:Akhil:Pathivada:How:are:you?",":");
		System.out.println(st2.countTokens());
		while(st2.hasMoreTokens())
		{
			System.out.println(st2.nextToken());
		}
		System.out.println("------------");
		StringTokenizer st3=new StringTokenizer("Hello:Akhil:Pathivada:How:are:you?",":",true);
		System.out.println(st3.countTokens());
		while(st3.hasMoreTokens())
		{
			System.out.println(st3.nextToken());
		}
		
		System.out.println("------------");
		StringTokenizer st4=new StringTokenizer("Hello:Akhil:Pathivada:How:are:you?",":",false);
		System.out.println(st4.countTokens());
		while(st4.hasMoreTokens())
		{
			System.out.println(st4.nextToken());
		}
		
	}
}
/*
6
Hello
Akhil
Pathivada
How
are
you?
------------
6
Hello
Akhil
Pathivada
How
are
you?
------------
11
Hello
:
Akhil
:
Pathivada
:
How
:
are
:
you?
------------
6
Hello
Akhil
Pathivada
How
are
you?

*/