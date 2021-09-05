//extension to Example 5 
class Animal
{  
	void eat()
	{
		System.out.println("animal is eating...");
	}  
}  
class Dog extends Animal
{  
	void eat()
	{
		System.out.println("dog is eating...");
	}  
}  
class BabyDog1 extends Dog
{  
	
}
class Example6
{
	public static void main(String args[])
	{  
		Animal a=new BabyDog1();  
		a.eat();  
	}
}
/*
output : 

			dog is eating...
*/