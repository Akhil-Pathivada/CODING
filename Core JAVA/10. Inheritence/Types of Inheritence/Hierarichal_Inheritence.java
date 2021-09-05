class Animal
{
	void feature1()
	{
		System.out.println("it can EATING....");
	}
}
class Dog extends Animal
{
	void feature2()
	{
		System.out.println("it can BARKING....");
	}
}
class Cat extends Animal
{
	void feature3()
	{
		System.out.println("it can MEOWING....");
		//super.feature1();
	}
}
class Hierarichal_Inheritence
{
	public static void main(String args[])
	{
		Cat ob=new Cat();
		ob.feature1();
		//ob.feature2();//COMPILE TIME ERROR
		ob.feature3();
	}
}
/* 
output :
		it can EATING....
		it can MEOWING....
		
		*/