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
class BabyDog extends Dog
{
	void feature3()
	{
		System.out.println("it can WEEP....");
	}
}
class Multilevel_Inheritence
{
	public static void main(String args[])
	{
		BabyDog ob=new BabyDog();
		ob.feature1();
		ob.feature2();
		ob.feature3();
	}
}
/*
	output: 
	
			it can EAT....
			it can BARK....
			it can WEEP....
			
			
			*/
