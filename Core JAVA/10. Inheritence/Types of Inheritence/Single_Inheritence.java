class Animal
{
	void feature1()
	{
		System.out.println("it can EAT....");
	}
}
class Dog extends Animal
{
	void feature2()
	{
		System.out.println("it can BARK....");
	}
}
class Single_Inheritence
{
	public static void main(String args[])
	{
		Dog ob=new Dog();
		ob.feature1();
		ob.feature2();
	}
}
/*
output :
		it can EAT....
		it can BARK....
		
		*/