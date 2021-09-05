// Write a program to prove that the default constructor of the super class is available to sub class by default
class One 
{
	One()
	{
		System.out.println("Super class called ");
	}
}
class Two extends One
{
	Two()
	{
		// super();  // by 'default' , 'super()' statement is present
		System.out.println("Sub class called ");
	}
}
class InheritenceDemo3
{
	public static void main(String args[])
	{
		Two ob=new Two();
	}
}
/*
output :


Super class called
Sub class called

*/